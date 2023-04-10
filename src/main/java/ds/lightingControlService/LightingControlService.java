package ds.lightingControlService;

import ds.SmartBuilding;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class LightingControlService extends LightingControlServiceGrpc.LightingControlServiceImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        LightingControlService lightingControlService = new LightingControlService();
        int port = 60052;
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
            SwitchLightOnResponse reply = SwitchLightOnResponse.newBuilder().setStatus("Success").build();
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
            SwitchLightOffResponse reply = SwitchLightOffResponse.newBuilder().setStatus("Fail").build();
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
        SetTimeResponse reply = SetTimeResponse.newBuilder().setStatus("Set time success").build();
        System.out.println("You can set time of switch on lighting!");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }
}
