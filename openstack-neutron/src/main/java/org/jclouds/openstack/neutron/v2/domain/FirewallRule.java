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
package org.jclouds.openstack.neutron.v2.domain;

import java.beans.ConstructorProperties;

import javax.inject.Named;

public class FirewallRule {

   public enum IpVersion {
      IPV4(4),
      IPV6(6),
      UNRECOGNIZED(Integer.MAX_VALUE);;

      private final int version;

      IpVersion(int version) {
         this.version = version;
      }

      public int version() {
         return this.version;
      }

      public static IpVersion fromValue(String value) {
         try {
            int statusCode = Integer.parseInt(value);
            switch (statusCode) {
               case 4:
                  return IPV4;
               case 6:
                  return IPV6;
               default:
                  return IPV4;
            }
         } catch (NumberFormatException e) {
            return UNRECOGNIZED;
         }
      }
   }

   private String id;
   @Named("tenant_id")
   private String tenantId;
   @Named("name")
   private String name;
   @Named("description")
   private String description;
   @Named("firewall_policy_id")
   private String firewallPolicyId;
   @Named("shared")
   private boolean shared;
   @Named("protocol")
   private String protocol;
   @Named("ip_version")
   private IpVersion ipVersion;
   @Named("source_ip_address")
   private String sourceIpAddress;
   @Named("destination_ip_address")
   private String destinationIpAddress;
   @Named("source_port")
   private String sourcePort;
   @Named("destination_port")
   private String destinationPort;
   @Named("position")
   private Integer position;
   @Named("action")
   private String action;
   @Named("enabled")
   private boolean enabled;

   @ConstructorProperties({"id", "tenant_id", "name", "description", "firewall_policy_id", "shared", "protocol", "ip_version", "source_ip_address",
           "destination_ip_address", "source_port", "destination_port", "position", "action", "enabled"})
   protected FirewallRule(String id, String tenantId, String name, String description, String firewallPolicyId, boolean shared, String protocol,
                          IpVersion ipVersion, String sourceIpAddress, String destinationIpAddress, String sourcePort, String destinationPort, Integer position,
                          String action, boolean enabled) {
      this.id = id;
      this.tenantId = tenantId;
      this.name = name;
      this.description = description;
      this.firewallPolicyId = firewallPolicyId;
      this.shared = shared;
      this.protocol = protocol;
      this.ipVersion = ipVersion;
      this.sourceIpAddress = sourceIpAddress;
      this.destinationIpAddress = destinationIpAddress;
      this.sourcePort = sourcePort;
      this.destinationPort = destinationPort;
      this.position = position;
      this.action = action;
      this.enabled = enabled;
   }

   private FirewallRule() {}

   public String getId() {
      return id;
   }

   public String getTenantId() {
      return tenantId;
   }

   public String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

   public String getFirewallPolicyId() {
      return firewallPolicyId;
   }

   public boolean isShared() {
      return shared;
   }

   public String getProtocol() {
      return protocol;
   }

   public IpVersion getIpVersion() {
      return ipVersion;
   }

   public String getSourceIpAddress() {
      return sourceIpAddress;
   }

   public String getDestinationIpAddress() {
      return destinationIpAddress;
   }

   public String getSourcePort() {
      return sourcePort;
   }

   public String getDestinationPort() {
      return destinationPort;
   }

   public int getPosition() {
      return position;
   }

   public String getAction() {
      return action;
   }

   public boolean isEnabled() {
      return enabled;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof FirewallRule)) return false;

      FirewallRule that = (FirewallRule) o;

      if (enabled != that.enabled) return false;
      if (shared != that.shared) return false;
      if (action != null ? !action.equals(that.action) : that.action != null) return false;
      if (description != null ? !description.equals(that.description) : that.description != null) return false;
      if (destinationIpAddress != null ? !destinationIpAddress.equals(that.destinationIpAddress) : that.destinationIpAddress != null) return false;
      if (destinationPort != null ? !destinationPort.equals(that.destinationPort) : that.destinationPort != null) return false;
      if (firewallPolicyId != null ? !firewallPolicyId.equals(that.firewallPolicyId) : that.firewallPolicyId != null) return false;
      if (id != null ? !id.equals(that.id) : that.id != null) return false;
      if (ipVersion != that.ipVersion) return false;
      if (name != null ? !name.equals(that.name) : that.name != null) return false;
      if (position != null ? !position.equals(that.position) : that.position != null) return false;
      if (protocol != null ? !protocol.equals(that.protocol) : that.protocol != null) return false;
      if (sourceIpAddress != null ? !sourceIpAddress.equals(that.sourceIpAddress) : that.sourceIpAddress != null) return false;
      if (sourcePort != null ? !sourcePort.equals(that.sourcePort) : that.sourcePort != null) return false;
      if (tenantId != null ? !tenantId.equals(that.tenantId) : that.tenantId != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = id != null ? id.hashCode() : 0;
      result = 31 * result + (tenantId != null ? tenantId.hashCode() : 0);
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (description != null ? description.hashCode() : 0);
      result = 31 * result + (firewallPolicyId != null ? firewallPolicyId.hashCode() : 0);
      result = 31 * result + (shared ? 1 : 0);
      result = 31 * result + (protocol != null ? protocol.hashCode() : 0);
      result = 31 * result + (ipVersion != null ? ipVersion.hashCode() : 0);
      result = 31 * result + (sourceIpAddress != null ? sourceIpAddress.hashCode() : 0);
      result = 31 * result + (destinationIpAddress != null ? destinationIpAddress.hashCode() : 0);
      result = 31 * result + (sourcePort != null ? sourcePort.hashCode() : 0);
      result = 31 * result + (destinationPort != null ? destinationPort.hashCode() : 0);
      result = 31 * result + (position != null ? position.hashCode() : 0);
      result = 31 * result + (action != null ? action.hashCode() : 0);
      result = 31 * result + (enabled ? 1 : 0);
      return result;
   }

   @Override
   public String toString() {
      return "FirewallRule{" +
              "id='" + id + '\'' +
              ", tenantId='" + tenantId + '\'' +
              ", name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", firewallPolicyId='" + firewallPolicyId + '\'' +
              ", shared=" + shared +
              ", protocol='" + protocol + '\'' +
              ", ipVersion='" + ipVersion + '\'' +
              ", sourceIpAddress='" + sourceIpAddress + '\'' +
              ", destinationIpAddress='" + destinationIpAddress + '\'' +
              ", sourcePort='" + sourcePort + '\'' +
              ", destinationPort='" + destinationPort + '\'' +
              ", position=" + position +
              ", action='" + action + '\'' +
              ", enabled=" + enabled +
              '}';
   }

   public static Builder builder() {
      return new Builder();
   }

   public Builder toBuilder() {
      return new Builder().fromFirewallRule(this);
   }

   public static class Builder {
      protected String id;
      protected String tenantId;
      protected String name;
      protected String description;
      protected String firewallPolicyId;
      protected boolean shared;
      protected String protocol;
      protected IpVersion ipVersion;
      protected String sourceIpAddress;
      protected String destinationIpAddress;
      protected String sourcePort;
      protected String destinationPort;
      protected Integer position;
      protected String action;
      protected boolean enabled;

      public Builder id(String id) {
         this.id = id;
         return this;
      }

      public Builder tenantId(String tenantId) {
         this.tenantId = tenantId;
         return this;
      }

      public Builder name(String name) {
         this.name = name;
         return this;
      }

      public Builder description(String description) {
         this.description = description;
         return this;
      }

      public Builder firewallPolicyId(String firewallPolicyId) {
         this.firewallPolicyId = firewallPolicyId;
         return this;
      }

      public Builder shared(boolean shared) {
         this.shared = shared;
         return this;
      }

      public Builder protocol(String protocol) {
         this.protocol = protocol;
         return this;
      }

      public Builder ipVersion(IpVersion ipVersion) {
         this.ipVersion = ipVersion;
         return this;
      }

      public Builder sourceIpAddress(String sourceIpAddress) {
         this.sourceIpAddress = sourceIpAddress;
         return this;
      }

      public Builder destinationIpAddress(String destinationIpAddress) {
         this.destinationIpAddress = destinationIpAddress;
         return this;
      }

      public Builder sourcePort(String sourcePort) {
         this.sourcePort = sourcePort;
         return this;
      }

      public Builder destinationPort(String destinationPort) {
         this.destinationPort = destinationPort;
         return this;
      }

      public Builder position(Integer position) {
         this.position = position;
         return this;
      }

      public Builder action(String action) {
         this.action = action;
         return this;
      }

      public Builder enabled(boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      public FirewallRule build() {
         return new FirewallRule(id, tenantId, name, description, firewallPolicyId, shared, protocol,
                 ipVersion, sourceIpAddress, destinationIpAddress, sourcePort, destinationPort, position, action, enabled);
      }

      public Builder fromFirewallRule(FirewallRule in) {
         return this
                 .id(in.getId())
                 .tenantId(in.getTenantId())
                 .name(in.getName())
                 .description(in.getDescription())
                 .firewallPolicyId(in.getFirewallPolicyId())
                 .shared(in.isShared())
                 .protocol(in.getProtocol())
                 .ipVersion(in.getIpVersion())
                 .sourceIpAddress(in.getSourceIpAddress())
                 .destinationIpAddress(in.getDestinationIpAddress())
                 .sourcePort(in.getSourcePort())
                 .destinationPort(in.getDestinationPort())
                 .position(in.getPosition())
                 .action(in.getAction())
                 .enabled(in.isEnabled());
      }
   }

}
