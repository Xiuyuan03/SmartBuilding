package ds.securityControlService;

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
    comments = "Source: SecurityControlService.proto")
public final class SecurityControlServiceGrpc {

  private SecurityControlServiceGrpc() {}

  public static final String SERVICE_NAME = "securityControlService.SecurityControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.securityControlService.UnlockDoorRequest,
      ds.securityControlService.UnlockDoorResponse> getUnlockDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unlockDoor",
      requestType = ds.securityControlService.UnlockDoorRequest.class,
      responseType = ds.securityControlService.UnlockDoorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.securityControlService.UnlockDoorRequest,
      ds.securityControlService.UnlockDoorResponse> getUnlockDoorMethod() {
    io.grpc.MethodDescriptor<ds.securityControlService.UnlockDoorRequest, ds.securityControlService.UnlockDoorResponse> getUnlockDoorMethod;
    if ((getUnlockDoorMethod = SecurityControlServiceGrpc.getUnlockDoorMethod) == null) {
      synchronized (SecurityControlServiceGrpc.class) {
        if ((getUnlockDoorMethod = SecurityControlServiceGrpc.getUnlockDoorMethod) == null) {
          SecurityControlServiceGrpc.getUnlockDoorMethod = getUnlockDoorMethod = 
              io.grpc.MethodDescriptor.<ds.securityControlService.UnlockDoorRequest, ds.securityControlService.UnlockDoorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "securityControlService.SecurityControlService", "unlockDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.UnlockDoorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.UnlockDoorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityControlServiceMethodDescriptorSupplier("unlockDoor"))
                  .build();
          }
        }
     }
     return getUnlockDoorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.securityControlService.LockDoorRequest,
      ds.securityControlService.LockDoorResponse> getLockDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lockDoor",
      requestType = ds.securityControlService.LockDoorRequest.class,
      responseType = ds.securityControlService.LockDoorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.securityControlService.LockDoorRequest,
      ds.securityControlService.LockDoorResponse> getLockDoorMethod() {
    io.grpc.MethodDescriptor<ds.securityControlService.LockDoorRequest, ds.securityControlService.LockDoorResponse> getLockDoorMethod;
    if ((getLockDoorMethod = SecurityControlServiceGrpc.getLockDoorMethod) == null) {
      synchronized (SecurityControlServiceGrpc.class) {
        if ((getLockDoorMethod = SecurityControlServiceGrpc.getLockDoorMethod) == null) {
          SecurityControlServiceGrpc.getLockDoorMethod = getLockDoorMethod = 
              io.grpc.MethodDescriptor.<ds.securityControlService.LockDoorRequest, ds.securityControlService.LockDoorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "securityControlService.SecurityControlService", "lockDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.LockDoorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.LockDoorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityControlServiceMethodDescriptorSupplier("lockDoor"))
                  .build();
          }
        }
     }
     return getLockDoorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.securityControlService.ActivateAlarmRequest,
      ds.securityControlService.ActivateAlarmResponse> getActivateAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "activateAlarm",
      requestType = ds.securityControlService.ActivateAlarmRequest.class,
      responseType = ds.securityControlService.ActivateAlarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.securityControlService.ActivateAlarmRequest,
      ds.securityControlService.ActivateAlarmResponse> getActivateAlarmMethod() {
    io.grpc.MethodDescriptor<ds.securityControlService.ActivateAlarmRequest, ds.securityControlService.ActivateAlarmResponse> getActivateAlarmMethod;
    if ((getActivateAlarmMethod = SecurityControlServiceGrpc.getActivateAlarmMethod) == null) {
      synchronized (SecurityControlServiceGrpc.class) {
        if ((getActivateAlarmMethod = SecurityControlServiceGrpc.getActivateAlarmMethod) == null) {
          SecurityControlServiceGrpc.getActivateAlarmMethod = getActivateAlarmMethod = 
              io.grpc.MethodDescriptor.<ds.securityControlService.ActivateAlarmRequest, ds.securityControlService.ActivateAlarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "securityControlService.SecurityControlService", "activateAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.ActivateAlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.ActivateAlarmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityControlServiceMethodDescriptorSupplier("activateAlarm"))
                  .build();
          }
        }
     }
     return getActivateAlarmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.securityControlService.DeactivateAlarmRequest,
      ds.securityControlService.DeactivateAlarmResponse> getDeactivateAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deactivateAlarm",
      requestType = ds.securityControlService.DeactivateAlarmRequest.class,
      responseType = ds.securityControlService.DeactivateAlarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.securityControlService.DeactivateAlarmRequest,
      ds.securityControlService.DeactivateAlarmResponse> getDeactivateAlarmMethod() {
    io.grpc.MethodDescriptor<ds.securityControlService.DeactivateAlarmRequest, ds.securityControlService.DeactivateAlarmResponse> getDeactivateAlarmMethod;
    if ((getDeactivateAlarmMethod = SecurityControlServiceGrpc.getDeactivateAlarmMethod) == null) {
      synchronized (SecurityControlServiceGrpc.class) {
        if ((getDeactivateAlarmMethod = SecurityControlServiceGrpc.getDeactivateAlarmMethod) == null) {
          SecurityControlServiceGrpc.getDeactivateAlarmMethod = getDeactivateAlarmMethod = 
              io.grpc.MethodDescriptor.<ds.securityControlService.DeactivateAlarmRequest, ds.securityControlService.DeactivateAlarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "securityControlService.SecurityControlService", "deactivateAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.DeactivateAlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.DeactivateAlarmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityControlServiceMethodDescriptorSupplier("deactivateAlarm"))
                  .build();
          }
        }
     }
     return getDeactivateAlarmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.securityControlService.LockDoorStatusRequest,
      ds.securityControlService.LockDoorStatusResponse> getGetLockStatusServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLockStatusServerStream",
      requestType = ds.securityControlService.LockDoorStatusRequest.class,
      responseType = ds.securityControlService.LockDoorStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.securityControlService.LockDoorStatusRequest,
      ds.securityControlService.LockDoorStatusResponse> getGetLockStatusServerStreamMethod() {
    io.grpc.MethodDescriptor<ds.securityControlService.LockDoorStatusRequest, ds.securityControlService.LockDoorStatusResponse> getGetLockStatusServerStreamMethod;
    if ((getGetLockStatusServerStreamMethod = SecurityControlServiceGrpc.getGetLockStatusServerStreamMethod) == null) {
      synchronized (SecurityControlServiceGrpc.class) {
        if ((getGetLockStatusServerStreamMethod = SecurityControlServiceGrpc.getGetLockStatusServerStreamMethod) == null) {
          SecurityControlServiceGrpc.getGetLockStatusServerStreamMethod = getGetLockStatusServerStreamMethod = 
              io.grpc.MethodDescriptor.<ds.securityControlService.LockDoorStatusRequest, ds.securityControlService.LockDoorStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "securityControlService.SecurityControlService", "getLockStatusServerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.LockDoorStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.LockDoorStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityControlServiceMethodDescriptorSupplier("getLockStatusServerStream"))
                  .build();
          }
        }
     }
     return getGetLockStatusServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.securityControlService.ActivateAlarmRequest,
      ds.securityControlService.ActivateAlarmResponse> getActivateAlarmClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "activateAlarmClientStream",
      requestType = ds.securityControlService.ActivateAlarmRequest.class,
      responseType = ds.securityControlService.ActivateAlarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.securityControlService.ActivateAlarmRequest,
      ds.securityControlService.ActivateAlarmResponse> getActivateAlarmClientStreamMethod() {
    io.grpc.MethodDescriptor<ds.securityControlService.ActivateAlarmRequest, ds.securityControlService.ActivateAlarmResponse> getActivateAlarmClientStreamMethod;
    if ((getActivateAlarmClientStreamMethod = SecurityControlServiceGrpc.getActivateAlarmClientStreamMethod) == null) {
      synchronized (SecurityControlServiceGrpc.class) {
        if ((getActivateAlarmClientStreamMethod = SecurityControlServiceGrpc.getActivateAlarmClientStreamMethod) == null) {
          SecurityControlServiceGrpc.getActivateAlarmClientStreamMethod = getActivateAlarmClientStreamMethod = 
              io.grpc.MethodDescriptor.<ds.securityControlService.ActivateAlarmRequest, ds.securityControlService.ActivateAlarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "securityControlService.SecurityControlService", "activateAlarmClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.ActivateAlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.ActivateAlarmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityControlServiceMethodDescriptorSupplier("activateAlarmClientStream"))
                  .build();
          }
        }
     }
     return getActivateAlarmClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.securityControlService.DeactivateAlarmRequest,
      ds.securityControlService.DeactivateAlarmResponse> getDeactivateAlarmClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deactivateAlarmClientStream",
      requestType = ds.securityControlService.DeactivateAlarmRequest.class,
      responseType = ds.securityControlService.DeactivateAlarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.securityControlService.DeactivateAlarmRequest,
      ds.securityControlService.DeactivateAlarmResponse> getDeactivateAlarmClientStreamMethod() {
    io.grpc.MethodDescriptor<ds.securityControlService.DeactivateAlarmRequest, ds.securityControlService.DeactivateAlarmResponse> getDeactivateAlarmClientStreamMethod;
    if ((getDeactivateAlarmClientStreamMethod = SecurityControlServiceGrpc.getDeactivateAlarmClientStreamMethod) == null) {
      synchronized (SecurityControlServiceGrpc.class) {
        if ((getDeactivateAlarmClientStreamMethod = SecurityControlServiceGrpc.getDeactivateAlarmClientStreamMethod) == null) {
          SecurityControlServiceGrpc.getDeactivateAlarmClientStreamMethod = getDeactivateAlarmClientStreamMethod = 
              io.grpc.MethodDescriptor.<ds.securityControlService.DeactivateAlarmRequest, ds.securityControlService.DeactivateAlarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "securityControlService.SecurityControlService", "deactivateAlarmClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.DeactivateAlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.DeactivateAlarmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityControlServiceMethodDescriptorSupplier("deactivateAlarmClientStream"))
                  .build();
          }
        }
     }
     return getDeactivateAlarmClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.securityControlService.LockDoorRequest,
      ds.securityControlService.LockDoorResponse> getLockDoorBidirectionalStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lockDoorBidirectionalStream",
      requestType = ds.securityControlService.LockDoorRequest.class,
      responseType = ds.securityControlService.LockDoorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.securityControlService.LockDoorRequest,
      ds.securityControlService.LockDoorResponse> getLockDoorBidirectionalStreamMethod() {
    io.grpc.MethodDescriptor<ds.securityControlService.LockDoorRequest, ds.securityControlService.LockDoorResponse> getLockDoorBidirectionalStreamMethod;
    if ((getLockDoorBidirectionalStreamMethod = SecurityControlServiceGrpc.getLockDoorBidirectionalStreamMethod) == null) {
      synchronized (SecurityControlServiceGrpc.class) {
        if ((getLockDoorBidirectionalStreamMethod = SecurityControlServiceGrpc.getLockDoorBidirectionalStreamMethod) == null) {
          SecurityControlServiceGrpc.getLockDoorBidirectionalStreamMethod = getLockDoorBidirectionalStreamMethod = 
              io.grpc.MethodDescriptor.<ds.securityControlService.LockDoorRequest, ds.securityControlService.LockDoorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "securityControlService.SecurityControlService", "lockDoorBidirectionalStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.LockDoorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.securityControlService.LockDoorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityControlServiceMethodDescriptorSupplier("lockDoorBidirectionalStream"))
                  .build();
          }
        }
     }
     return getLockDoorBidirectionalStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecurityControlServiceStub newStub(io.grpc.Channel channel) {
    return new SecurityControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SecurityControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SecurityControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SecurityControlServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SecurityControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public void unlockDoor(ds.securityControlService.UnlockDoorRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.UnlockDoorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnlockDoorMethod(), responseObserver);
    }

    /**
     */
    public void lockDoor(ds.securityControlService.LockDoorRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLockDoorMethod(), responseObserver);
    }

    /**
     */
    public void activateAlarm(ds.securityControlService.ActivateAlarmRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.ActivateAlarmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateAlarmMethod(), responseObserver);
    }

    /**
     */
    public void deactivateAlarm(ds.securityControlService.DeactivateAlarmRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.DeactivateAlarmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeactivateAlarmMethod(), responseObserver);
    }

    /**
     * <pre>
     *server- side streaming RPC
     * </pre>
     */
    public void getLockStatusServerStream(ds.securityControlService.LockDoorStatusRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLockStatusServerStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *client-side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.securityControlService.ActivateAlarmRequest> activateAlarmClientStream(
        io.grpc.stub.StreamObserver<ds.securityControlService.ActivateAlarmResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getActivateAlarmClientStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.securityControlService.DeactivateAlarmRequest> deactivateAlarmClientStream(
        io.grpc.stub.StreamObserver<ds.securityControlService.DeactivateAlarmResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getDeactivateAlarmClientStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *bidirectional streamingRPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorRequest> lockDoorBidirectionalStream(
        io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getLockDoorBidirectionalStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnlockDoorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.securityControlService.UnlockDoorRequest,
                ds.securityControlService.UnlockDoorResponse>(
                  this, METHODID_UNLOCK_DOOR)))
          .addMethod(
            getLockDoorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.securityControlService.LockDoorRequest,
                ds.securityControlService.LockDoorResponse>(
                  this, METHODID_LOCK_DOOR)))
          .addMethod(
            getActivateAlarmMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.securityControlService.ActivateAlarmRequest,
                ds.securityControlService.ActivateAlarmResponse>(
                  this, METHODID_ACTIVATE_ALARM)))
          .addMethod(
            getDeactivateAlarmMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.securityControlService.DeactivateAlarmRequest,
                ds.securityControlService.DeactivateAlarmResponse>(
                  this, METHODID_DEACTIVATE_ALARM)))
          .addMethod(
            getGetLockStatusServerStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.securityControlService.LockDoorStatusRequest,
                ds.securityControlService.LockDoorStatusResponse>(
                  this, METHODID_GET_LOCK_STATUS_SERVER_STREAM)))
          .addMethod(
            getActivateAlarmClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.securityControlService.ActivateAlarmRequest,
                ds.securityControlService.ActivateAlarmResponse>(
                  this, METHODID_ACTIVATE_ALARM_CLIENT_STREAM)))
          .addMethod(
            getDeactivateAlarmClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.securityControlService.DeactivateAlarmRequest,
                ds.securityControlService.DeactivateAlarmResponse>(
                  this, METHODID_DEACTIVATE_ALARM_CLIENT_STREAM)))
          .addMethod(
            getLockDoorBidirectionalStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.securityControlService.LockDoorRequest,
                ds.securityControlService.LockDoorResponse>(
                  this, METHODID_LOCK_DOOR_BIDIRECTIONAL_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SecurityControlServiceStub extends io.grpc.stub.AbstractStub<SecurityControlServiceStub> {
    private SecurityControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecurityControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public void unlockDoor(ds.securityControlService.UnlockDoorRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.UnlockDoorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnlockDoorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lockDoor(ds.securityControlService.LockDoorRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLockDoorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void activateAlarm(ds.securityControlService.ActivateAlarmRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.ActivateAlarmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateAlarmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deactivateAlarm(ds.securityControlService.DeactivateAlarmRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.DeactivateAlarmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeactivateAlarmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server- side streaming RPC
     * </pre>
     */
    public void getLockStatusServerStream(ds.securityControlService.LockDoorStatusRequest request,
        io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorStatusResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetLockStatusServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *client-side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.securityControlService.ActivateAlarmRequest> activateAlarmClientStream(
        io.grpc.stub.StreamObserver<ds.securityControlService.ActivateAlarmResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getActivateAlarmClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.securityControlService.DeactivateAlarmRequest> deactivateAlarmClientStream(
        io.grpc.stub.StreamObserver<ds.securityControlService.DeactivateAlarmResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDeactivateAlarmClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *bidirectional streamingRPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorRequest> lockDoorBidirectionalStream(
        io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getLockDoorBidirectionalStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SecurityControlServiceBlockingStub extends io.grpc.stub.AbstractStub<SecurityControlServiceBlockingStub> {
    private SecurityControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecurityControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public ds.securityControlService.UnlockDoorResponse unlockDoor(ds.securityControlService.UnlockDoorRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnlockDoorMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.securityControlService.LockDoorResponse lockDoor(ds.securityControlService.LockDoorRequest request) {
      return blockingUnaryCall(
          getChannel(), getLockDoorMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.securityControlService.ActivateAlarmResponse activateAlarm(ds.securityControlService.ActivateAlarmRequest request) {
      return blockingUnaryCall(
          getChannel(), getActivateAlarmMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.securityControlService.DeactivateAlarmResponse deactivateAlarm(ds.securityControlService.DeactivateAlarmRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeactivateAlarmMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server- side streaming RPC
     * </pre>
     */
    public java.util.Iterator<ds.securityControlService.LockDoorStatusResponse> getLockStatusServerStream(
        ds.securityControlService.LockDoorStatusRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetLockStatusServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SecurityControlServiceFutureStub extends io.grpc.stub.AbstractStub<SecurityControlServiceFutureStub> {
    private SecurityControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecurityControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.securityControlService.UnlockDoorResponse> unlockDoor(
        ds.securityControlService.UnlockDoorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnlockDoorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.securityControlService.LockDoorResponse> lockDoor(
        ds.securityControlService.LockDoorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLockDoorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.securityControlService.ActivateAlarmResponse> activateAlarm(
        ds.securityControlService.ActivateAlarmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateAlarmMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.securityControlService.DeactivateAlarmResponse> deactivateAlarm(
        ds.securityControlService.DeactivateAlarmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeactivateAlarmMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNLOCK_DOOR = 0;
  private static final int METHODID_LOCK_DOOR = 1;
  private static final int METHODID_ACTIVATE_ALARM = 2;
  private static final int METHODID_DEACTIVATE_ALARM = 3;
  private static final int METHODID_GET_LOCK_STATUS_SERVER_STREAM = 4;
  private static final int METHODID_ACTIVATE_ALARM_CLIENT_STREAM = 5;
  private static final int METHODID_DEACTIVATE_ALARM_CLIENT_STREAM = 6;
  private static final int METHODID_LOCK_DOOR_BIDIRECTIONAL_STREAM = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SecurityControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SecurityControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNLOCK_DOOR:
          serviceImpl.unlockDoor((ds.securityControlService.UnlockDoorRequest) request,
              (io.grpc.stub.StreamObserver<ds.securityControlService.UnlockDoorResponse>) responseObserver);
          break;
        case METHODID_LOCK_DOOR:
          serviceImpl.lockDoor((ds.securityControlService.LockDoorRequest) request,
              (io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorResponse>) responseObserver);
          break;
        case METHODID_ACTIVATE_ALARM:
          serviceImpl.activateAlarm((ds.securityControlService.ActivateAlarmRequest) request,
              (io.grpc.stub.StreamObserver<ds.securityControlService.ActivateAlarmResponse>) responseObserver);
          break;
        case METHODID_DEACTIVATE_ALARM:
          serviceImpl.deactivateAlarm((ds.securityControlService.DeactivateAlarmRequest) request,
              (io.grpc.stub.StreamObserver<ds.securityControlService.DeactivateAlarmResponse>) responseObserver);
          break;
        case METHODID_GET_LOCK_STATUS_SERVER_STREAM:
          serviceImpl.getLockStatusServerStream((ds.securityControlService.LockDoorStatusRequest) request,
              (io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorStatusResponse>) responseObserver);
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
        case METHODID_ACTIVATE_ALARM_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.activateAlarmClientStream(
              (io.grpc.stub.StreamObserver<ds.securityControlService.ActivateAlarmResponse>) responseObserver);
        case METHODID_DEACTIVATE_ALARM_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.deactivateAlarmClientStream(
              (io.grpc.stub.StreamObserver<ds.securityControlService.DeactivateAlarmResponse>) responseObserver);
        case METHODID_LOCK_DOOR_BIDIRECTIONAL_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.lockDoorBidirectionalStream(
              (io.grpc.stub.StreamObserver<ds.securityControlService.LockDoorResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SecurityControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.securityControlService.SecurityControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityControlService");
    }
  }

  private static final class SecurityControlServiceFileDescriptorSupplier
      extends SecurityControlServiceBaseDescriptorSupplier {
    SecurityControlServiceFileDescriptorSupplier() {}
  }

  private static final class SecurityControlServiceMethodDescriptorSupplier
      extends SecurityControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SecurityControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SecurityControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecurityControlServiceFileDescriptorSupplier())
              .addMethod(getUnlockDoorMethod())
              .addMethod(getLockDoorMethod())
              .addMethod(getActivateAlarmMethod())
              .addMethod(getDeactivateAlarmMethod())
              .addMethod(getGetLockStatusServerStreamMethod())
              .addMethod(getActivateAlarmClientStreamMethod())
              .addMethod(getDeactivateAlarmClientStreamMethod())
              .addMethod(getLockDoorBidirectionalStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
