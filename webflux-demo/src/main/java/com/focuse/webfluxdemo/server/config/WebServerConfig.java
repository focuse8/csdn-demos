package com.focuse.webfluxdemo.server.config;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.SocketAddress;

/**
 * @author ：
 * @date ：Created in 2020/8/24 下午3:28
 * @description：
 * @modified By：
 */
@Configuration
public class WebServerConfig {

    private static Bootstrap bootstrap;

    @Bean
    public WebServerFactoryCustomizer serverFactoryCustomizer() {
        return new WebServerFactoryCustomizer<NettyReactiveWebServerFactory>() {
            @Override
            public void customize(NettyReactiveWebServerFactory factory) {
                System.out.println(">>>>>>> customize");
                factory.addServerCustomizers(httpServer ->
                        httpServer.tcpConfiguration(tcpServer -> tcpServer.bootstrap(bootstrap -> {
                                    return bootstrap.option(ChannelOption.SO_BACKLOG, 1000).childHandler(new ChannelInitializer<Channel>() {

                                        @Override
                                        protected void initChannel(Channel ch) throws Exception {
                                            ch.pipeline().addLast(new ChannelOutboundHandlerAdapter() {
                                                @Override
                                                public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress,
                                                                    SocketAddress localAddress, ChannelPromise promise) throws Exception {
                                                    System.out.println("connect ccccccc" + promise.channel().remoteAddress());
                                                    super.connect(ctx, remoteAddress, localAddress, promise);
                                                }

                                                @Override
                                                public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception{
                                                    System.out.println("disconnect dddddd" + promise.channel().remoteAddress());
                                                    super.disconnect(ctx, promise);
                                                }

                                                @Override
                                                public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
                                                    System.out.println("close llllllll" + promise.channel().remoteAddress());
                                                    super.close(ctx, promise);
                                                }
                                            }).addLast(new ChannelInboundHandlerAdapter(){
                                                @Override
                                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                                    System.out.println(System.currentTimeMillis() / 1000 + " act aaaaaaa" + ctx.channel().remoteAddress());
                                                    super.channelActive(ctx);

                                                }

                                                @Override
                                                public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                                    System.out.println(System.currentTimeMillis() / 1000 + " inact iiiiiii" + ctx.channel().remoteAddress());
                                                    super.channelInactive(ctx);
                                                }

                                                @Override
                                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
                                                        throws Exception {
                                                    System.out.println(System.currentTimeMillis() / 1000 + " excep eeeee" + ctx.channel().remoteAddress());
                                                    cause.printStackTrace();
                                                    super.exceptionCaught(ctx, cause);
                                                }

                                            });
                                        }
                                    });
                                })
                                .doOnConnection(connection -> {

                                })
                        )
                );
            }
        };
    }
}
