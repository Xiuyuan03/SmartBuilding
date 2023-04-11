package ds.client;

import ds.lightingControlService.*;
import ds.securityControlService.*;
import ds.temperatureControlService.*;
import io.grpc.*;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class SmartBuildingControllerGUI implements ActionListener {
    private JTextField entry1, reply1;
    private JTextField entry2, reply2;
    private JTextField entry3, reply3;


    private JPanel getSecurityControlServiceJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke SecurityControlService");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextField("", 10);
        reply1 .setEditable(false);
        panel.add(reply1 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getLightingControlServiceJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("",10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke LightingControlService");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextField("", 10);
        reply2 .setEditable(false);
        panel.add(reply2 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getTemperatureControlServiceJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("",10);
        panel.add(entry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke TemperatureControlService");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JTextField("", 10);
        reply3 .setEditable(false);
        panel.add(reply3 );

        panel.setLayout(boxlayout);

        return panel;

    }

    public static void main(String[] args) {

        SmartBuildingControllerGUI gui = new SmartBuildingControllerGUI();

        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("SmartBuildingController");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add( getSecurityControlServiceJPanel() );
        panel.add( getLightingControlServiceJPanel() );
        panel.add( getTemperatureControlServiceJPanel() );

        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String label = button.getActionCommand();


        if (label.equals("Invoke SecurityControlService")) {
            System.out.println("Security Control Service to be invoked ...");
            String action = "";
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60051).usePlaintext().build();
            Metadata metadata = new Metadata();
            Metadata.Key<String> key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
            metadata.put(key, "Bearer my_token");
            if(action.equals("unlockDoor")){
                SecurityControlServiceGrpc.SecurityControlServiceBlockingStub blockingStub = MetadataUtils.attachHeaders(SecurityControlServiceGrpc.newBlockingStub(channel), metadata);
                // Set a deadline of 5 second for the remote invocation
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                //preparing message to send
                UnlockDoorRequest request = UnlockDoorRequest.newBuilder().setDoorId(Integer.parseInt(entry1.getText())).build();
                //retreving reply from service
                Context.CancellableContext context = Context.current().withCancellation();
                try{
                    UnlockDoorResponse response = blockingStub.withDeadline(deadline).unlockDoor(request);
                    reply1.setText(response.getStatus());
                }catch(StatusRuntimeException exception){
                    if (exception.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()) {
                        // Handle timeout error
                        System.out.println("Timeout error!");
                    } else {
                        // Handle other errors
                        throw new StatusRuntimeException(
                                Status.INTERNAL.withDescription("An error occurred while invoking remote method"));
                    }
                }finally {
                    context.cancel(null);
                }



            }else if(action.equals("lockDoorBidirectionalStream")) {
                SecurityControlServiceGrpc.SecurityControlServiceStub stub = SecurityControlServiceGrpc.newStub(channel);
                StreamObserver<LockDoorResponse> responseData = new StreamObserver<LockDoorResponse>() {
                    @Override
                    public void onNext(LockDoorResponse lockDoorResponse) {
                        reply1.setText(lockDoorResponse.getStatus());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error!!");
                    }

                    @Override
                    public void onCompleted() {
                        channel.shutdown();
                    }
                };
                StreamObserver<LockDoorRequest> requestDate = stub.lockDoorBidirectionalStream(responseData);
                for (int i = 0; i < 10; i++) {
                    LockDoorRequest lockDoorRequest = LockDoorRequest.newBuilder().setDoorId(i).build();
                    requestDate.onNext(lockDoorRequest);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                requestDate.onCompleted();

                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }else if(action.equals("activateAlarmClientStream")){
                SecurityControlServiceGrpc.SecurityControlServiceStub stub = SecurityControlServiceGrpc.newStub(channel);
                StreamObserver<ActivateAlarmResponse> responseData = new StreamObserver<ActivateAlarmResponse>() {
                    @Override
                    public void onNext(ActivateAlarmResponse activateAlarmResponse) {
                        reply1.setText(activateAlarmResponse.getStatus());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error!!");
                    }

                    @Override
                    public void onCompleted() {
                        channel.shutdown();
                    }
                };
                StreamObserver<ActivateAlarmRequest> requestDate = stub.activateAlarmClientStream(responseData);
                for (int i = 0; i < 10; i++) {
                    ActivateAlarmRequest activateAlarmRequest = ActivateAlarmRequest.newBuilder().setDoorId(i).build();
                    requestDate.onNext(activateAlarmRequest);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                requestDate.onCompleted();
                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }else if(action.equals("deactivateAlarmClientStream")){
                SecurityControlServiceGrpc.SecurityControlServiceStub stub = SecurityControlServiceGrpc.newStub(channel);
                StreamObserver<DeactivateAlarmResponse> responseData = new StreamObserver<DeactivateAlarmResponse>() {
                    @Override
                    public void onNext(DeactivateAlarmResponse deactivateAlarmResponse) {
                        reply1.setText(deactivateAlarmResponse.getStatus());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error!!");
                    }

                    @Override
                    public void onCompleted() {
                        channel.shutdown();
                    }
                };
                StreamObserver<DeactivateAlarmRequest> requestDate = stub.deactivateAlarmClientStream(responseData);
                for (int i = 0; i < 10; i++) {
                    DeactivateAlarmRequest deactivateAlarmRequest = DeactivateAlarmRequest.newBuilder().setDoorId(i).build();
                    requestDate.onNext(deactivateAlarmRequest);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                requestDate.onCompleted();
                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }else if (label.equals("Invoke LightingControlService")) {
            System.out.println("Lighting Control Service to be invoked ...");
            String action = "";
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60052).usePlaintext().build();
            Metadata metadata = new Metadata();
            Metadata.Key<String> key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
            metadata.put(key, "Bearer my_token");
            if(action.equals("SwitchLightOn")){
                LightingControlServiceGrpc.LightingControlServiceBlockingStub blockingStub = MetadataUtils.attachHeaders(LightingControlServiceGrpc.newBlockingStub(channel), metadata);
                // Set a deadline of 5 second for the remote invocation
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                //preparing message to send
                SwitchLightOnRequest request = SwitchLightOnRequest.newBuilder().setDetects(Boolean.parseBoolean(entry2.getText())).build();
                //retreving reply from service
                Context.CancellableContext context = Context.current().withCancellation();
                try{
                    SwitchLightOnResponse response = blockingStub.withDeadline(deadline).switchLightOn(request);
                    reply2.setText( String.valueOf( response.getStatus()) );
                }catch(StatusRuntimeException exception){
                    if(exception.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()){
                        // Handle timeout error
                        System.out.println("Timeout error!");
                    }else{
                        // Handle other errors
                        throw new StatusRuntimeException(
                                Status.INTERNAL.withDescription("An error occurred while invoking remote method"));
                    }
                }finally{
                context.cancel(null);
                }
            }else if(action.equals("SwitchLightOff")){
                LightingControlServiceGrpc.LightingControlServiceBlockingStub blockingStub = MetadataUtils.attachHeaders(LightingControlServiceGrpc.newBlockingStub(channel), metadata);
                // Set a deadline of 5 second for the remote invocation
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                //preparing message to send
                SwitchLightOffRequest request = SwitchLightOffRequest.newBuilder().setDetects(Boolean.parseBoolean(entry2.getText())).build();
                //retreving reply from service
                Context.CancellableContext context = Context.current().withCancellation();
                try{
                    SwitchLightOffResponse response = blockingStub.withDeadline(deadline).switchLightOff(request);
                    reply2.setText( String.valueOf( response.getStatus()) );
                }catch(StatusRuntimeException exception){
                    if(exception.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()){
                        // Handle timeout error
                        System.out.println("Timeout error!");
                    }else{
                        // Handle other errors
                        throw new StatusRuntimeException(
                                Status.INTERNAL.withDescription("An error occurred while invoking remote method"));
                    }
                }finally{
                    context.cancel(null);
                }
            }else if(action.equals("SetTime")){
                LightingControlServiceGrpc.LightingControlServiceBlockingStub blockingStub = MetadataUtils.attachHeaders(LightingControlServiceGrpc.newBlockingStub(channel), metadata);
                // Set a deadline of 5 second for the remote invocation
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                //preparing message to send
                SetTimeRequest request = SetTimeRequest.newBuilder().setTime(Float.parseFloat(entry2.getText())).build();
                //retreving reply from service
                Context.CancellableContext context = Context.current().withCancellation();
                try{
                    SetTimeResponse response = blockingStub.withDeadline(deadline).setSwitchLightTime(request);
                    reply2.setText( String.valueOf( response.getStatus()) );
                }catch(StatusRuntimeException exception){
                    if(exception.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()){
                        // Handle timeout error
                        System.out.println("Timeout error!");
                    }else{
                        // Handle other errors
                        throw new StatusRuntimeException(
                                Status.INTERNAL.withDescription("An error occurred while invoking remote method"));
                    }
                }finally{
                    context.cancel(null);
                }
            }else{

            }
        }else if (label.equals("Invoke TemperatureControlService")) {
            System.out.println("Temperature Control Service to be invoked ...");
            String action = "";
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60053).usePlaintext().build();
            Metadata metadata = new Metadata();
            Metadata.Key<String> key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
            metadata.put(key, "Bearer my_token");
            if(action.equals("SetTemperature")){
                TemperatureControlServiceGrpc.TemperatureControlServiceBlockingStub blockingStub = MetadataUtils.attachHeaders(TemperatureControlServiceGrpc.newBlockingStub(channel), metadata);
                // Set a deadline of 5 second for the remote invocation
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                //preparing message to send
                SetTemperatureRequest request = SetTemperatureRequest.newBuilder().setValue(Float.parseFloat(entry3.getText())).build();
                //retreving reply from service
                Context.CancellableContext context = Context.current().withCancellation();
                try{
                    SetTemperatureResponse response = blockingStub.withDeadline(deadline).setTemperature(request);
                    reply3.setText( ( response.getStatus()) );
                }catch(StatusRuntimeException exception){
                    if(exception.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()){
                        // Handle timeout error
                        System.out.println("Timeout error!");
                    }else{
                        // Handle other errors
                        throw new StatusRuntimeException(
                                Status.INTERNAL.withDescription("An error occurred while invoking remote method"));
                    }
                }finally{
                    context.cancel(null);
                }
            }else if(action.equals("GetTemperature")){
                TemperatureControlServiceGrpc.TemperatureControlServiceBlockingStub blockingStub = MetadataUtils.attachHeaders(TemperatureControlServiceGrpc.newBlockingStub(channel), metadata);
                // Set a deadline of 5 second for the remote invocation
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                //preparing message to send
                GetTemperatureRequest request = GetTemperatureRequest.newBuilder().setRequestValue(String.valueOf(entry3.getText())).build();
                //retreving reply from service
                Context.CancellableContext context = Context.current().withCancellation();
                try{
                    GetTemperatureResponse response = blockingStub.withDeadline(deadline).getTemperature(request);
                    reply3.setText(( response.getGetValue()));
                }catch(StatusRuntimeException exception){
                    if(exception.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()){
                        // Handle timeout error
                        System.out.println("Timeout error!");
                    }else{
                        // Handle other errors
                        throw new StatusRuntimeException(
                                Status.INTERNAL.withDescription("An error occurred while invoking remote method"));
                    }
                }finally{
                    context.cancel(null);
                }
            }else if(action.equals("SetTemperatureTime")){
                TemperatureControlServiceGrpc.TemperatureControlServiceBlockingStub blockingStub = MetadataUtils.attachHeaders(TemperatureControlServiceGrpc.newBlockingStub(channel), metadata);
                // Set a deadline of 5 second for the remote invocation
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                //preparing message to send
                SetTemperatureTimeRequest request = SetTemperatureTimeRequest.newBuilder().setTime(Float.parseFloat(entry3.getText())).build();
                //retreving reply from service
                Context.CancellableContext context = Context.current().withCancellation();
                try{
                    SetTemperatureTimeResponse response = blockingStub.withDeadline(deadline).setTemperatureTime(request);
                    reply3.setText( ( response.getStatus()) );
                }catch(StatusRuntimeException exception){
                    if(exception.getStatus().getCode() == Status.DEADLINE_EXCEEDED.getCode()){
                        // Handle timeout error
                        System.out.println("Timeout error!");
                    }else{
                        // Handle other errors
                        throw new StatusRuntimeException(
                                Status.INTERNAL.withDescription("An error occurred while invoking remote method"));
                    }
                }finally{
                    context.cancel(null);
                }
            }else{

            }
        }else{

        }
    }
}
