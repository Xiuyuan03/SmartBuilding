package ds.temperatureControlService;

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
    comments = "Source: temperatureControlService.proto")
public final class TemperatureControlServiceGrpc {

  private TemperatureControlServiceGrpc() {}

  public static final String SERVICE_NAME = "temperatureControlService.TemperatureControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.temperatureControlService.SetTemperatureRequest,
      ds.temperatureControlService.SetTemperatureResponse> getSetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setTemperature",
      requestType = ds.temperatureControlService.SetTemperatureRequest.class,
      responseType = ds.temperatureControlService.SetTemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.temperatureControlService.SetTemperatureRequest,
      ds.temperatureControlService.SetTemperatureResponse> getSetTemperatureMethod() {
    io.grpc.MethodDescriptor<ds.temperatureControlService.SetTemperatureRequest, ds.temperatureControlService.SetTemperatureResponse> getSetTemperatureMethod;
    if ((getSetTemperatureMethod = TemperatureControlServiceGrpc.getSetTemperatureMethod) == null) {
      synchronized (TemperatureControlServiceGrpc.class) {
        if ((getSetTemperatureMethod = TemperatureControlServiceGrpc.getSetTemperatureMethod) == null) {
          TemperatureControlServiceGrpc.getSetTemperatureMethod = getSetTemperatureMethod = 
              io.grpc.MethodDescriptor.<ds.temperatureControlService.SetTemperatureRequest, ds.temperatureControlService.SetTemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "temperatureControlService.TemperatureControlService", "setTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.temperatureControlService.SetTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.temperatureControlService.SetTemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemperatureControlServiceMethodDescriptorSupplier("setTemperature"))
                  .build();
          }
        }
     }
     return getSetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.temperatureControlService.GetTemperatureRequest,
      ds.temperatureControlService.GetTemperatureResponse> getGetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTemperature",
      requestType = ds.temperatureControlService.GetTemperatureRequest.class,
      responseType = ds.temperatureControlService.GetTemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.temperatureControlService.GetTemperatureRequest,
      ds.temperatureControlService.GetTemperatureResponse> getGetTemperatureMethod() {
    io.grpc.MethodDescriptor<ds.temperatureControlService.GetTemperatureRequest, ds.temperatureControlService.GetTemperatureResponse> getGetTemperatureMethod;
    if ((getGetTemperatureMethod = TemperatureControlServiceGrpc.getGetTemperatureMethod) == null) {
      synchronized (TemperatureControlServiceGrpc.class) {
        if ((getGetTemperatureMethod = TemperatureControlServiceGrpc.getGetTemperatureMethod) == null) {
          TemperatureControlServiceGrpc.getGetTemperatureMethod = getGetTemperatureMethod = 
              io.grpc.MethodDescriptor.<ds.temperatureControlService.GetTemperatureRequest, ds.temperatureControlService.GetTemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "temperatureControlService.TemperatureControlService", "getTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.temperatureControlService.GetTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.temperatureControlService.GetTemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemperatureControlServiceMethodDescriptorSupplier("getTemperature"))
                  .build();
          }
        }
     }
     return getGetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.temperatureControlService.SetTemperatureTimeRequest,
      ds.temperatureControlService.SetTemperatureTimeResponse> getSetTemperatureTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setTemperatureTime",
      requestType = ds.temperatureControlService.SetTemperatureTimeRequest.class,
      responseType = ds.temperatureControlService.SetTemperatureTimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.temperatureControlService.SetTemperatureTimeRequest,
      ds.temperatureControlService.SetTemperatureTimeResponse> getSetTemperatureTimeMethod() {
    io.grpc.MethodDescriptor<ds.temperatureControlService.SetTemperatureTimeRequest, ds.temperatureControlService.SetTemperatureTimeResponse> getSetTemperatureTimeMethod;
    if ((getSetTemperatureTimeMethod = TemperatureControlServiceGrpc.getSetTemperatureTimeMethod) == null) {
      synchronized (TemperatureControlServiceGrpc.class) {
        if ((getSetTemperatureTimeMethod = TemperatureControlServiceGrpc.getSetTemperatureTimeMethod) == null) {
          TemperatureControlServiceGrpc.getSetTemperatureTimeMethod = getSetTemperatureTimeMethod = 
              io.grpc.MethodDescriptor.<ds.temperatureControlService.SetTemperatureTimeRequest, ds.temperatureControlService.SetTemperatureTimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "temperatureControlService.TemperatureControlService", "setTemperatureTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.temperatureControlService.SetTemperatureTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.temperatureControlService.SetTemperatureTimeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemperatureControlServiceMethodDescriptorSupplier("setTemperatureTime"))
                  .build();
          }
        }
     }
     return getSetTemperatureTimeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemperatureControlServiceStub newStub(io.grpc.Channel channel) {
    return new TemperatureControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemperatureControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TemperatureControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemperatureControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TemperatureControlServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class TemperatureControlServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setTemperature(ds.temperatureControlService.SetTemperatureRequest request,
        io.grpc.stub.StreamObserver<ds.temperatureControlService.SetTemperatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetTemperatureMethod(), responseObserver);
    }

    /**
     */
    public void getTemperature(ds.temperatureControlService.GetTemperatureRequest request,
        io.grpc.stub.StreamObserver<ds.temperatureControlService.GetTemperatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTemperatureMethod(), responseObserver);
    }

    /**
     */
    public void setTemperatureTime(ds.temperatureControlService.SetTemperatureTimeRequest request,
        io.grpc.stub.StreamObserver<ds.temperatureControlService.SetTemperatureTimeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetTemperatureTimeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetTemperatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.temperatureControlService.SetTemperatureRequest,
                ds.temperatureControlService.SetTemperatureResponse>(
                  this, METHODID_SET_TEMPERATURE)))
          .addMethod(
            getGetTemperatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.temperatureControlService.GetTemperatureRequest,
                ds.temperatureControlService.GetTemperatureResponse>(
                  this, METHODID_GET_TEMPERATURE)))
          .addMethod(
            getSetTemperatureTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.temperatureControlService.SetTemperatureTimeRequest,
                ds.temperatureControlService.SetTemperatureTimeResponse>(
                  this, METHODID_SET_TEMPERATURE_TIME)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class TemperatureControlServiceStub extends io.grpc.stub.AbstractStub<TemperatureControlServiceStub> {
    private TemperatureControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureControlServiceStub(channel, callOptions);
    }

    /**
     */
    public void setTemperature(ds.temperatureControlService.SetTemperatureRequest request,
        io.grpc.stub.StreamObserver<ds.temperatureControlService.SetTemperatureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTemperature(ds.temperatureControlService.GetTemperatureRequest request,
        io.grpc.stub.StreamObserver<ds.temperatureControlService.GetTemperatureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setTemperatureTime(ds.temperatureControlService.SetTemperatureTimeRequest request,
        io.grpc.stub.StreamObserver<ds.temperatureControlService.SetTemperatureTimeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetTemperatureTimeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class TemperatureControlServiceBlockingStub extends io.grpc.stub.AbstractStub<TemperatureControlServiceBlockingStub> {
    private TemperatureControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureControlServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.temperatureControlService.SetTemperatureResponse setTemperature(ds.temperatureControlService.SetTemperatureRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetTemperatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.temperatureControlService.GetTemperatureResponse getTemperature(ds.temperatureControlService.GetTemperatureRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTemperatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.temperatureControlService.SetTemperatureTimeResponse setTemperatureTime(ds.temperatureControlService.SetTemperatureTimeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetTemperatureTimeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class TemperatureControlServiceFutureStub extends io.grpc.stub.AbstractStub<TemperatureControlServiceFutureStub> {
    private TemperatureControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureControlServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.temperatureControlService.SetTemperatureResponse> setTemperature(
        ds.temperatureControlService.SetTemperatureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.temperatureControlService.GetTemperatureResponse> getTemperature(
        ds.temperatureControlService.GetTemperatureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTemperatureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.temperatureControlService.SetTemperatureTimeResponse> setTemperatureTime(
        ds.temperatureControlService.SetTemperatureTimeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetTemperatureTimeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_TEMPERATURE = 0;
  private static final int METHODID_GET_TEMPERATURE = 1;
  private static final int METHODID_SET_TEMPERATURE_TIME = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TemperatureControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TemperatureControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_TEMPERATURE:
          serviceImpl.setTemperature((ds.temperatureControlService.SetTemperatureRequest) request,
              (io.grpc.stub.StreamObserver<ds.temperatureControlService.SetTemperatureResponse>) responseObserver);
          break;
        case METHODID_GET_TEMPERATURE:
          serviceImpl.getTemperature((ds.temperatureControlService.GetTemperatureRequest) request,
              (io.grpc.stub.StreamObserver<ds.temperatureControlService.GetTemperatureResponse>) responseObserver);
          break;
        case METHODID_SET_TEMPERATURE_TIME:
          serviceImpl.setTemperatureTime((ds.temperatureControlService.SetTemperatureTimeRequest) request,
              (io.grpc.stub.StreamObserver<ds.temperatureControlService.SetTemperatureTimeResponse>) responseObserver);
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

  private static abstract class TemperatureControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemperatureControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.temperatureControlService.TemperatureControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TemperatureControlService");
    }
  }

  private static final class TemperatureControlServiceFileDescriptorSupplier
      extends TemperatureControlServiceBaseDescriptorSupplier {
    TemperatureControlServiceFileDescriptorSupplier() {}
  }

  private static final class TemperatureControlServiceMethodDescriptorSupplier
      extends TemperatureControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TemperatureControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TemperatureControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemperatureControlServiceFileDescriptorSupplier())
              .addMethod(getSetTemperatureMethod())
              .addMethod(getGetTemperatureMethod())
              .addMethod(getSetTemperatureTimeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
