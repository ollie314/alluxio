/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.logserver;

import alluxio.ProcessUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Alluxio log server receiving logs pushed from Alluxio servers.
 */
public final class AlluxioLogServer {
  private static Logger LOG = LoggerFactory.getLogger(AlluxioLogServer.class);
  /**
   * Main entry point of {@link AlluxioLogServer}.
   *
   * @param args command line arguments that will be parsed to initialize {@link AlluxioLogServer}
   */
  public static void main(String[] args) {
    final AlluxioLogServerProcess process = new AlluxioLogServerProcess(args[0]);
    ProcessUtils.addShutdownHook(process);
    ProcessUtils.run(process);
  }

  /**
   * Private constructor to prevent user from instantiating any
   * {@link AlluxioLogServer} instance.
   */
  private AlluxioLogServer() {} // prevent instantiation
}
