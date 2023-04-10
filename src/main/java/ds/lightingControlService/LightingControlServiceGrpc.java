package ds.lightingControlService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: lightingControlService.proto")
public final class LightingControlServiceGrpc {

  private LightingControlServiceGrpc() {}

  public static final String SERVICE_NAME = "lightingControlService.LightingControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.lightingControlService.SwitchLightOnRequest,
      ds.lightingControlService.SwitchLightOnResponse> getSwitchLightOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchLightOn",
      requestType = ds.lightingControlService.SwitchLightOnRequest.class,
      responseType = ds.lightingControlService.SwitchLightOnResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.lightingControlService.SwitchLightOnRequest,
      ds.lightingControlService.SwitchLightOnResponse> getSwitchLightOnMethod() {
    io.grpc.MethodDescriptor<ds.lightingControlService.SwitchLightOnRequest, ds.lightingControlService.SwitchLightOnResponse> getSwitchLightOnMethod;
    if ((getSwitchLightOnMethod = LightingControlServiceGrpc.getSwitchLightOnMethod) == null) {
      synchronized (LightingControlServiceGrpc.class) {
        if ((getSwitchLightOnMethod = LightingControlServiceGrpc.getSwitchLightOnMethod) == null) {
          LightingControlServiceGrpc.getSwitchLightOnMethod = getSwitchLightOnMethod = 
              io.grpc.MethodDescriptor.<ds.lightingControlService.SwitchLightOnRequest, ds.lightingControlService.SwitchLightOnResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lightingControlService.LightingControlService", "switchLightOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingControlService.SwitchLightOnRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingControlService.SwitchLightOnResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingControlServiceMethodDescriptorSupplier("switchLightOn"))
                  .build();
          }
        }
     }
     return getSwitchLightOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.lightingControlService.SwitchLightOffRequest,
      ds.lightingControlService.SwitchLightOffResponse> getSwitchLightOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchLightOff",
      requestType = ds.lightingControlService.SwitchLightOffRequest.class,
      responseType = ds.lightingControlService.SwitchLightOffResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.lightingControlService.SwitchLightOffRequest,
      ds.lightingControlService.SwitchLightOffResponse> getSwitchLightOffMethod() {
    io.grpc.MethodDescriptor<ds.lightingControlService.SwitchLightOffRequest, ds.lightingControlService.SwitchLightOffResponse> getSwitchLightOffMethod;
    if ((getSwitchLightOffMethod = LightingControlServiceGrpc.getSwitchLightOffMethod) == null) {
      synchronized (LightingControlServiceGrpc.class) {
        if ((getSwitchLightOffMethod = LightingControlServiceGrpc.getSwitchLightOffMethod) == null) {
          LightingControlServiceGrpc.getSwitchLightOffMethod = getSwitchLightOffMethod = 
              io.grpc.MethodDescriptor.<ds.lightingControlService.SwitchLightOffRequest, ds.lightingControlService.SwitchLightOffResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lightingControlService.LightingControlService", "switchLightOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingControlService.SwitchLightOffRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingControlService.SwitchLightOffResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingControlServiceMethodDescriptorSupplier("switchLightOff"))
                  .build();
          }
        }
     }
     return getSwitchLightOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.lightingControlService.SetTimeRequest,
      ds.lightingControlService.SetTimeResponse> getSetSwitchLightTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setSwitchLightTime",
      requestType = ds.lightingControlService.SetTimeRequest.class,
      responseType = ds.lightingControlService.SetTimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.lightingControlService.SetTimeRequest,
      ds.lightingControlService.SetTimeResponse> getSetSwitchLightTimeMethod() {
    io.grpc.MethodDescriptor<ds.lightingControlService.SetTimeRequest, ds.lightingControlService.SetTimeResponse> getSetSwitchLightTimeMethod;
    if ((getSetSwitchLightTimeMethod = LightingControlServiceGrpc.getSetSwitchLightTimeMethod) == null) {
      synchronized (LightingControlServiceGrpc.class) {
        if ((getSetSwitchLightTimeMethod = LightingControlServiceGrpc.getSetSwitchLightTimeMethod) == null) {
          LightingControlServiceGrpc.getSetSwitchLightTimeMethod = getSetSwitchLightTimeMethod = 
              io.grpc.MethodDescriptor.<ds.lightingControlService.SetTimeRequest, ds.lightingControlService.SetTimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lightingControlService.LightingControlService", "setSwitchLightTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingControlService.SetTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingControlService.SetTimeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingControlServiceMethodDescriptorSupplier("setSwitchLightTime"))
                  .build();
          }
        }
     }
     return getSetSwitchLightTimeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightingControlServiceStub newStub(io.grpc.Channel channel) {
    return new LightingControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightingControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightingControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightingControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightingControlServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class LightingControlServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchLightOn(ds.lightingControlService.SwitchLightOnRequest request,
        io.grpc.stub.StreamObserver<ds.lightingControlService.SwitchLightOnResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchLightOnMethod(), responseObserver);
    }

    /**
     */
    public void switchLightOff(ds.lightingControlService.SwitchLightOffRequest request,
        io.grpc.stub.StreamObserver<ds.lightingControlService.SwitchLightOffResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchLightOffMethod(), responseObserver);
    }

    /**
     */
    public void setSwitchLightTime(ds.lightingControlService.SetTimeRequest request,
        io.grpc.stub.StreamObserver<ds.lightingControlService.SetTimeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetSwitchLightTimeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchLightOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.lightingControlService.SwitchLightOnRequest,
                ds.lightingControlService.SwitchLightOnResponse>(
                  this, METHODID_SWITCH_LIGHT_ON)))
          .addMethod(
            getSwitchLightOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.lightingControlService.SwitchLightOffRequest,
                ds.lightingControlService.SwitchLightOffResponse>(
                  this, METHODID_SWITCH_LIGHT_OFF)))
          .addMethod(
            getSetSwitchLightTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.lightingControlService.SetTimeRequest,
                ds.lightingControlService.SetTimeResponse>(
                  this, METHODID_SET_SWITCH_LIGHT_TIME)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightingControlServiceStub extends io.grpc.stub.AbstractStub<LightingControlServiceStub> {
    private LightingControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingControlServiceStub(channel, callOptions);
    }

    /**
     */
    public void switchLightOn(ds.lightingControlService.SwitchLightOnRequest request,
        io.grpc.stub.StreamObserver<ds.lightingControlService.SwitchLightOnResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchLightOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void switchLightOff(ds.lightingControlService.SwitchLightOffRequest request,
        io.grpc.stub.StreamObserver<ds.lightingControlService.SwitchLightOffResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchLightOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setSwitchLightTime(ds.lightingControlService.SetTimeRequest request,
        io.grpc.stub.StreamObserver<ds.lightingControlService.SetTimeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetSwitchLightTimeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightingControlServiceBlockingStub extends io.grpc.stub.AbstractStub<LightingControlServiceBlockingStub> {
    private LightingControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingControlServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.lightingControlService.SwitchLightOnResponse switchLightOn(ds.lightingControlService.SwitchLightOnRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchLightOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.lightingControlService.SwitchLightOffResponse switchLightOff(ds.lightingControlService.SwitchLightOffRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchLightOffMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.lightingControlService.SetTimeResponse setSwitchLightTime(ds.lightingControlService.SetTimeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetSwitchLightTimeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightingControlServiceFutureStub extends io.grpc.stub.AbstractStub<LightingControlServiceFutureStub> {
    private LightingControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingControlServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.lightingControlService.SwitchLightOnResponse> switchLightOn(
        ds.lightingControlService.SwitchLightOnRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchLightOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.lightingControlService.SwitchLightOffResponse> switchLightOff(
        ds.lightingControlService.SwitchLightOffRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchLightOffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.lightingControlService.SetTimeResponse> setSwitchLightTime(
        ds.lightingControlService.SetTimeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetSwitchLightTimeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_LIGHT_ON = 0;
  private static final int METHODID_SWITCH_LIGHT_OFF = 1;
  private static final int METHODID_SET_SWITCH_LIGHT_TIME = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightingControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightingControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_LIGHT_ON:
          serviceImpl.switchLightOn((ds.lightingControlService.SwitchLightOnRequest) request,
              (io.grpc.stub.StreamObserver<ds.lightingControlService.SwitchLightOnResponse>) responseObserver);
          break;
        case METHODID_SWITCH_LIGHT_OFF:
          serviceImpl.switchLightOff((ds.lightingControlService.SwitchLightOffRequest) request,
              (io.grpc.stub.StreamObserver<ds.lightingControlService.SwitchLightOffResponse>) responseObserver);
          break;
        case METHODID_SET_SWITCH_LIGHT_TIME:
          serviceImpl.setSwitchLightTime((ds.lightingControlService.SetTimeRequest) request,
              (io.grpc.stub.StreamObserver<ds.lightingControlService.SetTimeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightingControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightingControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.lightingControlService.LightingControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightingControlService");
    }
  }

  private static final class LightingControlServiceFileDescriptorSupplier
      extends LightingControlServiceBaseDescriptorSupplier {
    LightingControlServiceFileDescriptorSupplier() {}
  }

  private static final class LightingControlServiceMethodDescriptorSupplier
      extends LightingControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightingControlServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LightingControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightingControlServiceFileDescriptorSupplier())
              .addMethod(getSwitchLightOnMethod())
              .addMethod(getSwitchLightOffMethod())
              .addMethod(getSetSwitchLightTimeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
