package ds.temperatureControlService;

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

public class TemperatureControlService extends TemperatureControlServiceGrpc.TemperatureControlServiceImplBase{
    public static void main(String[] args) throws InterruptedException, IOException {
        TemperatureControlService temperatureControlService = new TemperatureControlService();
        Properties prop = temperatureControlService.getProperties();
        //jmdns registration service
        registerService(prop);
        int port = Integer.parseInt( prop.getProperty("service_port") );
        Server server = ServerBuilder.forPort(port)
                .addService(temperatureControlService)
                .build()
                .start();
        System.out.println("Temperature Control Service started, listening on " + port);
        server.awaitTermination();
    }

    @Override
    public void setTemperature(SetTemperatureRequest request, StreamObserver<SetTemperatureResponse> responseObserver) {
        float value = request.getValue();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.setTemperature(value);
        SetTemperatureResponse reply = SetTemperatureResponse.newBuilder().setStatus("Set temperature "+value+" success").build();
        System.out.println("The building will set temperature value that is "+value+" !");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void getTemperature(GetTemperatureRequest request, StreamObserver<GetTemperatureResponse> responseObserver) {
        String requestValue = request.getRequestValue();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        GetTemperatureResponse reply = GetTemperatureResponse.newBuilder().setGetValue(Float.parseFloat("Set temperature "+smartBuilding.getTemperature()+" success")).build();
        System.out.println("The temperature value is "+smartBuilding.getTemperature()+" !");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }

    @Override
    public void setTemperatureTime(SetTemperatureTimeRequest request, StreamObserver<SetTemperatureTimeResponse> responseObserver) {
        float time = request.getTime();
        SmartBuilding smartBuilding = SmartBuilding.getInstance();
        smartBuilding.setTemperatureDurationTime(time);
        SetTemperatureTimeResponse reply = SetTemperatureTimeResponse.newBuilder().setStatus("Set Temperature Time is "+time+".").build();
        System.out.println("The building set temperature time is "+time+" !");
        responseObserver.onNext( reply );
        responseObserver.onCompleted();
    }
    private Properties getProperties(){
        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/temperatureControlService.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("temperature Control Service properies ...");
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
