/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.demo;

import org.apache.dubbo.demo.hello.GreeterWrapperService;
import org.apache.dubbo.demo.hello.HelloReply;
import org.apache.dubbo.demo.hello.HelloRequest;

import java.util.concurrent.CompletableFuture;

public class GreeterWrapperServiceImpl implements GreeterWrapperService {

    @Override
    public HelloReply sayHello(HelloRequest request) {
        StringBuilder responseBuilder = new StringBuilder(request.getName());
        for (int i = 0; i < 20; i++) {
            responseBuilder.append(responseBuilder);
        }
        return HelloReply.newBuilder().setMessage(responseBuilder.toString()).build();
    }

    @Override
    public CompletableFuture<HelloReply> sayHelloAsync(HelloRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            StringBuilder responseBuilder = new StringBuilder(request.getName());
            for (int i = 0; i < 20; i++) {
                responseBuilder.append(responseBuilder);
            }
            return HelloReply.newBuilder()
                    .setMessage(responseBuilder.toString())
                    .build();
        });
    }
}
