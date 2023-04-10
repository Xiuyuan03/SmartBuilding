package ds.temperatureControlService;

import ds.SmartBuilding;
import ds.jmdns.SecurityControlServiceRegistration;
import ds.jmdns.TemperatureControlServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class TemperatureControlService extends TemperatureControlServiceGrpc.TemperatureControlServiceImplBase{
    public static void main(String[] args) throws InterruptedException, IOException {
        TemperatureControlService temperatureControlService = new TemperatureControlService();
        int port = 60053;
        Server server = ServerBuilder.forPort(port)
                .addService(temperatureControlService)
                .build()
                .start();
        //jmdns registration service
        TemperatureControlServiceRegistration.register();
        System.out.println("Temperature Control Service started, listening on " + port);
        server.awaitTermination();
    }

    @Override
    public void setTemperature(SetTemperatureRequest request, StreamObserver<SetTemperatureResponse> responseObserver) {
        float value = request.getValue();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.setTemperature(value);
        SetTemperatureResponse reply = SetTemperatureResponse.newBuilder().setStatus("Set value success").build();
        System.out.println("The building will set temperature value that is "+value+" !");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void getTemperature(GetTemperatureRequest request, StreamObserver<GetTemperatureResponse> responseObserver) {
        String requestValue = request.getRequestValue();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        GetTemperatureResponse reply = GetTemperatureResponse.newBuilder().setGetValue(smartBuilding.getTemperature()).build();
        System.out.println("The temperature value is "+smartBuilding.getTemperature()+" !");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void setTemperatureTime(SetTemperatureTimeRequest request, StreamObserver<SetTemperatureTimeResponse> responseObserver) {
        float time = request.getTime();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.setTemperatureDurationTime(time);
        SetTemperatureTimeResponse reply = SetTemperatureTimeResponse.newBuilder().setStatus("SetTemperatureTime").build();
        System.out.println("The building set temperature time is "+time+" !");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }
}
