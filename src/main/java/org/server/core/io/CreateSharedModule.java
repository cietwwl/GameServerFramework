/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.server.core.io;

/**
 * 创建共享模块接口
 *
 * @author Hxms
 * @param <M> 共享模块类型
 */
public interface CreateSharedModule<M extends com.google.protobuf.GeneratedMessage> {

    /**
     * 创建模块对象
     *
     * @param data
     * @return 共享模块对象
     * @throws com.google.protobuf.InvalidProtocolBufferException 反序列化接口调用异常
     */
    M Create(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException;
}
