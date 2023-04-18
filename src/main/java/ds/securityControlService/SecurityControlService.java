package ds.securityControlService;

import ds.SmartBuilding;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class SecurityControlService extends SecurityControlServiceGrpc.SecurityControlServiceImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        SecurityControlService securityControlService = new SecurityControlService();
        Properties prop = securityControlService.getProperties();
        //jmdns registration service
        registerService(prop);
        int port = Integer.parseInt( prop.getProperty("service_port") );
        Server server = ServerBuilder.forPort(port)
                .addService(securityControlService)
                .build()
                .start();
        System.out.println("Security Control Service started, listening on " + port);
        server.awaitTermination();
    }

    @Override
    public void unlockDoor(UnlockDoorRequest request, StreamObserver<UnlockDoorResponse> responseObserver) {
        int doorId = request.getDoorId();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.getDoorIdToLockStatusMap().put(doorId,"Unlocked");
        UnlockDoorResponse reply = UnlockDoorResponse.newBuilder().setStatus("Unlock door " +doorId+" Success").build();
        System.out.println("The door "+doorId+" is unlock!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void lockDoor(LockDoorRequest request, StreamObserver<LockDoorResponse> responseObserver) {
        int doorId = request.getDoorId();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.getDoorIdToLockStatusMap().put(doorId,"Locked");
        LockDoorResponse reply = LockDoorResponse.newBuilder().setStatus("Lock door " +doorId+" Success").build();
        System.out.println("The door "+doorId+" is lock!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void activateAlarm(ActivateAlarmRequest request, StreamObserver<ActivateAlarmResponse> responseObserver) {
        int doorId = request.getDoorId();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.getDoorIdToAlarmMap().put(doorId,"Activate alarm");
        ActivateAlarmResponse reply = ActivateAlarmResponse.newBuilder().setStatus("Activate Alarm "+doorId).build();
        System.out.println("The door "+doorId+" is activate alarm!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void deactivateAlarm(DeactivateAlarmRequest request, StreamObserver<DeactivateAlarmResponse> responseObserver) {
        int doorId = request.getDoorId();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.getDoorIdToAlarmMap().put(doorId,"Deactivate alarm");
        DeactivateAlarmResponse reply = DeactivateAlarmResponse.newBuilder().setStatus("Deactivate Alarm "+doorId).build();
        System.out.println("The door "+doorId+" is deactivate alarm!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void getLockStatusServerStream(LockDoorStatusRequest request, StreamObserver<LockDoorStatusResponse> responseObserver) {
        String requestDoorId = request.getDoorIdRequest();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        Map<Integer,String> doorIdToLockDoorStatusMap = smartBuilding.getDoorIdToLockStatusMap();
        String[] doorIdArea =  requestDoorId.split("~");
        for (int i = Integer.parseInt(doorIdArea[0]); i < Integer.parseInt(doorIdArea[1]); i++) {
            responseObserver.onNext( LockDoorStatusResponse.newBuilder().setStatus(doorIdToLockDoorStatusMap.get(i)).build() );
        }
        System.out.println("Get lock door status success!");
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<ActivateAlarmRequest> activateAlarmClientStream(StreamObserver<ActivateAlarmResponse> responseObserver) {
        return new StreamObserver<ActivateAlarmRequest>(){

            @Override
            public void onNext(ActivateAlarmRequest activateAlarmRequest) {
                int doorId = activateAlarmRequest.getDoorId();
                SmartBuilding smartBuilding = SmartBuilding.getInstance();
                smartBuilding.getDoorIdToAlarmMap().put(doorId,"Activate alarm");
                System.out.println("The door "+doorId+" is activate alarm!");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error!!"+ Arrays.toString(throwable.getStackTrace()));
            }

            @Override
            public void onCompleted() {
                System.out.println("Activate alarm success!");
                responseObserver.onNext(ActivateAlarmResponse.newBuilder().setStatus("Success!").build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<DeactivateAlarmRequest> deactivateAlarmClientStream(StreamObserver<DeactivateAlarmResponse> responseObserver) {
        return new StreamObserver<DeactivateAlarmRequest>(){

            @Override
            public void onNext(DeactivateAlarmRequest deactivateAlarmRequest) {
                int doorId = deactivateAlarmRequest.getDoorId();
                SmartBuilding smartBuilding = SmartBuilding.getInstance();
                smartBuilding.getDoorIdToAlarmMap().put(doorId,"Deactivate alarm");
                System.out.println("The door "+doorId+" is deactivate alarm!");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error!!");
            }

            @Override
            public void onCompleted() {
                System.out.println("Deactivate alarm success!");
                responseObserver.onNext(DeactivateAlarmResponse.newBuilder().setStatus("Success!").build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<LockDoorRequest> lockDoorBidirectionalStream(StreamObserver<LockDoorResponse> responseObserver) {
        return new StreamObserver<LockDoorRequest>(){

            @Override
            public void onNext(LockDoorRequest lockDoorRequest) {
                int doorId = lockDoorRequest.getDoorId();
                SmartBuilding smartBuilding = SmartBuilding.getInstance();
                smartBuilding.getDoorIdToLockStatusMap().put(doorId,"Locked");
                System.out.println("The door "+doorId+" is lock!");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error!!");
            }

            @Override
            public void onCompleted() {
                System.out.println("Lock door success!");
                responseObserver.onNext(LockDoorResponse.newBuilder().setStatus("Success!").build());
                responseObserver.onCompleted();
            }
        };
    }
    public static void registerService(Properties prop){
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            String service_type = prop.getProperty("service_type");
            String service_name = prop.getProperty("service_name");
            int service_port = Integer.parseInt( prop.getProperty("service_port") );
            String service_description_properties = prop.getProperty("service_description");

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            //ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "LightingControlService", 60052, "service for basic LightingControlService operations");
            jmdns.registerService(serviceInfo);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private Properties getProperties(){
        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/securityControlService.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("security Control Service properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
            System.out.println("\t service_port: " +prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }
}
