package org.cloudfoundry.reconfiguration.play

import org.cloudfoundry.reconfiguration.play._
import org.cloudfoundry.reconfiguration.util.CloudUtils
import org.cloudfoundry.reconfiguration.util.StandardCloudUtils
import org.springframework.cloud.Cloud

class CloudConfig {
    
    def init() = {
        val CLOUD_UTILS = new StandardCloudUtils()
        if (CLOUD_UTILS.isInCloud()) {
            val cloud = CLOUD_UTILS.getCloudFactory().getCloud()
            
            Configurer.configure(new StandardApplicationConfiguration(), cloud, new StandardPropertySetter(cloud))
        }
    }
}