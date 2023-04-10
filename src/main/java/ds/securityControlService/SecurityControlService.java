package ds.securityControlService;

import ds.SmartBuilding;
import ds.service1.ResponseMessage;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Map;

public class SecurityControlService extends SecurityControlServiceGrpc.SecurityControlServiceImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        SecurityControlService securityControlService = new SecurityControlService();
        int port = 60051;
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
        UnlockDoorResponse reply = UnlockDoorResponse.newBuilder().setStatus("Success").build();
        System.out.println("The door "+doorId+" is unlock!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void lockDoor(LockDoorRequest request, StreamObserver<LockDoorResponse> responseObserver) {
        int doorId = request.getDoorId();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.getDoorIdToLockStatusMap().put(doorId,"Locked");
        LockDoorResponse reply = LockDoorResponse.newBuilder().setStatus("Success").build();
        System.out.println("The door "+doorId+" is lock!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void activateAlarm(ActivateAlarmRequest request, StreamObserver<ActivateAlarmResponse> responseObserver) {
        int doorId = request.getDoorId();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.getDoorIdToAlarmMap().put(doorId,"Activate alarm");
        ActivateAlarmResponse reply = ActivateAlarmResponse.newBuilder().setStatus("Activate Alarm").build();
        System.out.println("The door "+doorId+" is activate alarm!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void deactivateAlarm(DeactivateAlarmRequest request, StreamObserver<DeactivateAlarmResponse> responseObserver) {
        int doorId = request.getDoorId();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.getDoorIdToAlarmMap().put(doorId,"Deactivate alarm");
        DeactivateAlarmResponse reply = DeactivateAlarmResponse.newBuilder().setStatus("Deactivate Alarm").build();
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
                System.out.println("Error!!");
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
}
