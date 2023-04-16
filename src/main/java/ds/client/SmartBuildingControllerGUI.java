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
    private JTextField entry1,entry1_1, reply1;
    private JTextField entry2, reply2;
    private JTextField entry3, reply3;
    private JTextArea textResponse;
    private JComboBox comboOperation1,comboOperation2,comboOperation3;
    private String[] lightingControlServiceArray = new String[] {"SwitchLightOn", "SwitchLightOff", "SetTime"};
    private String[] temperatureControlServiceArray = new String[] {"SetTemperature", "GetTemperature", "SetTemperatureTime"};
    private String[] securityControlServiceArray = new String[] {"unlockDoor", "lockDoorBidirectionalStream", "activateAlarmClientStream","deactivateAlarmClientStream"};
    private JPanel getSecurityControlServiceJPanel() {
int assss
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        JLabel label = new JLabel("Enter value1")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        JLabel label1 = new JLabel("Enter value2")	;
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1_1 = new JTextField("",10);
        panel.add(entry1_1);
        comboOperation1 = new JComboBox();
        comboOperation1.setModel(new DefaultComboBoxModel(securityControlServiceArray));
        panel.add(comboOperation1);
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
        comboOperation2 = new JComboBox();
        comboOperation2.setModel(new DefaultComboBoxModel(lightingControlServiceArray));
        panel.add(comboOperation2);
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
        comboOperation3 = new JComboBox();
        comboOperation3.setModel(new DefaultComboBoxModel(temperatureControlServiceArray));
        panel.add(comboOperation3);
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
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60051).usePlaintext().build();
            Metadata metadata = new Metadata();
            Metadata.Key<String> key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
            metadata.put(key, "Bearer my_token");
            int index = comboOperation1.getSelectedIndex();
            String action = securityControlServiceArray[index];
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
                SecurityControlServiceGrpc.SecurityControlServiceStub stub = MetadataUtils.attachHeaders(SecurityControlServiceGrpc.newStub(channel), metadata);
                StreamObserver<LockDoorResponse> responseData = new StreamObserver<LockDoorResponse>() {
                    //retreving reply from service
                    Context.CancellableContext context = Context.current().withCancellation();
                    @Override
                    public void onNext(LockDoorResponse lockDoorResponse) {
                        reply1.setText(lockDoorResponse.getStatus());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error!!");
                        context.cancel(null);
                    }

                    @Override
                    public void onCompleted() { channel.shutdown(); }
                };
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                StreamObserver<LockDoorRequest> requestData = stub.withDeadline(deadline).withDeadline(deadline).lockDoorBidirectionalStream(responseData);
                for (int i = 0; i < 10; i++) {
                    LockDoorRequest lockDoorRequest = LockDoorRequest.newBuilder().setDoorId(i).build();
                    requestData.onNext(lockDoorRequest);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                requestData.onCompleted();

                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }else if(action.equals("activateAlarmClientStream")){
                SecurityControlServiceGrpc.SecurityControlServiceStub stub = MetadataUtils.attachHeaders(SecurityControlServiceGrpc.newStub(channel), metadata);
                StreamObserver<ActivateAlarmResponse> responseData = new StreamObserver<ActivateAlarmResponse>() {
                    //retreving reply from service
                    Context.CancellableContext context = Context.current().withCancellation();
                    @Override
                    public void onNext(ActivateAlarmResponse activateAlarmResponse) {
                        reply1.setText(activateAlarmResponse.getStatus());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error!!");
                        context.cancel(null);
                    }

                    @Override
                    public void onCompleted() {
                        channel.shutdown();
                    }
                };
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                StreamObserver<ActivateAlarmRequest> requestData = stub.withDeadline(deadline).activateAlarmClientStream(responseData);
                for (int i = 0; i < 10; i++) {
                    ActivateAlarmRequest activateAlarmRequest = ActivateAlarmRequest.newBuilder().setDoorId(i).build();
                    requestData.onNext(activateAlarmRequest);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                requestData.onCompleted();
                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }else if(action.equals("deactivateAlarmClientStream")){
                SecurityControlServiceGrpc.SecurityControlServiceStub stub = MetadataUtils.attachHeaders(SecurityControlServiceGrpc.newStub(channel), metadata);
                StreamObserver<DeactivateAlarmResponse> responseData = new StreamObserver<DeactivateAlarmResponse>() {
                    //retreving reply from service
                    Context.CancellableContext context = Context.current().withCancellation();
                    @Override
                    public void onNext(DeactivateAlarmResponse deactivateAlarmResponse) {
                        reply1.setText(deactivateAlarmResponse.getStatus());
                    }
                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error!!");
                        context.cancel(null);
                    }
                    @Override
                    public void onCompleted() {
                        channel.shutdown();
                    }
                };
                Deadline deadline = Deadline.after(5, TimeUnit.SECONDS);
                StreamObserver<DeactivateAlarmRequest> requestDate = stub.withDeadline(deadline).deactivateAlarmClientStream(responseData);
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
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60052).usePlaintext().build();
            Metadata metadata = new Metadata();
            Metadata.Key<String> key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
            metadata.put(key, "Bearer my_token");
            int index = comboOperation2.getSelectedIndex();
            String action = lightingControlServiceArray[index];
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
                    reply2.setText(response.getStatus());
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
                channel.shutdown();
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
                channel.shutdown();
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
                channel.shutdown();
            }
        }else if (label.equals("Invoke TemperatureControlService")) {
            System.out.println("Temperature Control Service to be invoked ...");
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60053).usePlaintext().build();
            Metadata metadata = new Metadata();
            Metadata.Key<String> key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
            metadata.put(key, "Bearer my_token");
            int index = comboOperation3.getSelectedIndex();
            String action = temperatureControlServiceArray[index];
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
                channel.shutdown();
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
                    reply3.setText(String.valueOf( response.getGetValue()));
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
                channel.shutdown();
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
                channel.shutdown();
            }
        }
    }
}
