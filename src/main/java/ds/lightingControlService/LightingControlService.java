package ds.lightingControlService;

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
import java.util.Properties;

public class LightingControlService extends LightingControlServiceGrpc.LightingControlServiceImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        LightingControlService lightingControlService = new LightingControlService();
        Properties prop = lightingControlService.getProperties();
        //jmdns registration service
        lightingControlService.registerService(prop);
        int port = Integer.valueOf( prop.getProperty("service_port") );
        Server server = ServerBuilder.forPort(port)
                .addService(lightingControlService)
                .build()
                .start();
        System.out.println("Lighting Control Service started, listening on " + port);
        server.awaitTermination();
    }

    @Override
    public void switchLightOn(SwitchLightOnRequest request, StreamObserver<SwitchLightOnResponse> responseObserver) {
        boolean detects = request.getDetects();
        if (detects) {
            SwitchLightOnResponse reply = SwitchLightOnResponse.newBuilder().setStatus("Switch light on Success").build();
            System.out.println("The Light switch on!");
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }else {
            System.out.println("The system doesn't detect people, it doesn't need to switch on the lights.");
        }
    }

    @Override
    public void switchLightOff(SwitchLightOffRequest request, StreamObserver<SwitchLightOffResponse> responseObserver) {
        boolean detects = request.getDetects();
        if (!detects) {
            SwitchLightOffResponse reply = SwitchLightOffResponse.newBuilder().setStatus("Switch light off Fail").build();
            System.out.println("The Light switch off!");
            responseObserver.onNext( reply );
            responseObserver.onCompleted();
        }else {
            System.out.println("The system detect people, it doesn't need to switch off the lights.");
        }
    }

    @Override
    public void setSwitchLightTime(SetTimeRequest request, StreamObserver<SetTimeResponse> responseObserver) {
        float time = request.getTime();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.setLightDurationTime(time);
        SetTimeResponse reply = SetTimeResponse.newBuilder().setStatus("Set time:" +time+" success").build();
        System.out.println("You can set time of switch on lighting!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }
    private Properties getProperties(){
        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/lightingControlService.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("lighting Control Service properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
            System.out.println("\t service_port: " +prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
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
}
