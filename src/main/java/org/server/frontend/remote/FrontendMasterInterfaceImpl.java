/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.server.frontend.remote;

import java.rmi.RemoteException;
import org.server.core.remote.RMIServiceInterfaceImpl;
import org.server.core.ShutdownService;
import org.server.frontend.FrontendServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrontendMasterInterfaceImpl extends RMIServiceInterfaceImpl<FrontendServer> implements FrontendMasterInterface {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4972220148590157592L;
	private static final Logger logger = LoggerFactory.getLogger(FrontendMasterInterfaceImpl.class);

    public FrontendMasterInterfaceImpl(FrontendServer server) throws RemoteException {
        super(server);
    }

    @Override
    public boolean shutdown() throws RemoteException {
        logger.info("接收管理服务关机命令...");
        
        ShutdownService service = new ShutdownService(getServer());
        service.shutdown();

        return true;
    }
}
