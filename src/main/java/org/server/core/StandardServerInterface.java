/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.server.core;

/**
 * 标准服务器接口
 *
 * @author Administrator
 */
public interface StandardServerInterface {

    /**
     * 执行控制台
     * @param cmd 命令字符串
     * @return 处理是否成功
     */
    boolean executeCommand(String cmd);
    
    /**
     * 开启服务
     */
    boolean start();
    
    /**
     * 停止服务
     */
    boolean stop();
}
