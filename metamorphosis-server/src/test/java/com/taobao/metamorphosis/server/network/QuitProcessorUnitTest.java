/*
 * (C) 2007-2012 Alibaba Group Holding Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Authors:
 *   wuhua <wq163@163.com> , boyan <killme2008@gmail.com>
 */
package com.taobao.metamorphosis.server.network;

import org.easymock.classextension.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.taobao.metamorphosis.network.QuitCommand;


public class QuitProcessorUnitTest extends BaseProcessorUnitTest {
    private QuitProcessor processor;


    @Before
    public void setUp() {
        this.mock();
        this.processor = new QuitProcessor(this.commandProcessor);
    }


    @Test
    public void testHandleRequest() throws Exception {
        this.conn.close(false);
        EasyMock.expectLastCall();
        this.mocksControl.replay();
        this.processor.handleRequest(new QuitCommand(), this.conn);
        this.mocksControl.verify();
    }
}