package com.focuse.webfluxdemo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：
 * @date ：Created in 2020/8/19 下午5:21
 * @description：
 * @modified By：
 */
public class ClientLauncher {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup(2);

        List<CompletableFuture<String>> list = new ArrayList<>();

        HttpClient httpClient = HttpClient.create(ConnectionProvider.create("myHttpClient", 10000))
                .tcpConfiguration(client ->
                        client.doOnConnected(conn -> conn
                                .addHandlerLast(new ReadTimeoutHandler(100))
                                .addHandlerLast(new WriteTimeoutHandler(100)))
                                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 200000)
                                .bootstrap(bootstrap -> bootstrap.group(group).channel(NioSocketChannel.class)));

        Bootstrap bootstrap = new Bootstrap().group(group).channel(NioSocketChannel.class).handler(new ChannelHandler() {
            @Override
            public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

            }

            @Override
            public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

            }

            @Override
            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

            }
        });
        ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("127.0.0.1", 8081));
        Channel channel = channelFuture.channel();
        LockSupport.parkNanos(50000000000l);
        if (channel.isActive()) {
            System.out.println("asdfasdfasf");
        }
        channel.writeAndFlush("asdfasdf");


//        WebClient client = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
//                .baseUrl("http://127.0.0.1:8081").build();
//        long l = System.currentTimeMillis();
//        System.out.println("*****************************allStart take ：" + - l / 1000 + "s");
//        for (int i = 0; i < 20; i++) {
//            System.out.println("******************send " + i);
//            Mono<String> result = client.post()
//                    .uri("/focuse/hello?name=" + (i + 1))
//                    .accept(MediaType.APPLICATION_JSON)
//                    .retrieve()
//                    .bodyToMono(String.class);
//            CompletableFuture<String> future = result.toFuture();
//            System.out.println("******************sended " + i);
//            future.whenComplete((r, e) -> {
//                System.out.println("whenComplete===" + Thread.currentThread().getName() + "== r：" + r);
//            });
//            list.add(future);
//            System.out.println(Thread.currentThread().getName() + ":" + "main do other thing ……");
//        }
//
//        for (CompletableFuture<String> future : list) {
//            future.get();
//        }

        //System.out.println("*****************************allEnd take ：" + (System.currentTimeMillis() - l) / 1000 + "s");
        System.out.println(Thread.currentThread().getName() + ":" + "main do other thing end");
    }
}
