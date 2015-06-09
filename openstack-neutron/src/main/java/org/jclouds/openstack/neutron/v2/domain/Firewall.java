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

/**
 * A Firewall
 *
 * @see <a
 *      href="http://docs.openstack.org/admin-guide-cloud/content/fwaas_api_abstractions.html">api
 *      doc</a>
 */
public class Firewall {

   private String id;
   @Named("tenant_id")
   private String tenantId;
   @Named("name")
   private String name;
   @Named("description")
   private String description;
   @Named("admin_state_up")
   private boolean adminStateUp;
   @Named("status")
   private String status;
   @Named("firewall_policy_id")
   private String firewallPolicyId;

   @ConstructorProperties({"id", "tenant_id", "name", "description", "admin_state_up",
           "status", "firewall_policy_id"})
   protected Firewall(String id, String tenantId, String name, String description, boolean adminStateUp, String status, String firewallPolicyId) {
      this.id = id;
      this.tenantId = tenantId;
      this.name = name;
      this.description = description;
      this.adminStateUp = adminStateUp;
      this.status = status;
      this.firewallPolicyId = firewallPolicyId;
   }

   private Firewall() {}

   /**
    * Copy constructor
    * @param firewall
    */
   private Firewall(Firewall firewall) {
      this(firewall.id, firewall.tenantId, firewall.name, firewall.description, firewall.adminStateUp, firewall.status, firewall.firewallPolicyId);
   }

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

   public boolean isAdminStateUp() {
      return adminStateUp;
   }

   public String getStatus() {
      return status;
   }

   public String getFirewallPolicyId() {
      return firewallPolicyId;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Firewall)) return false;

      Firewall firewall = (Firewall) o;

      if (adminStateUp != firewall.adminStateUp) return false;
      if (description != null ? !description.equals(firewall.description) : firewall.description != null) return false;
      if (firewallPolicyId != null ? !firewallPolicyId.equals(firewall.firewallPolicyId) : firewall.firewallPolicyId != null) return false;
      if (id != null ? !id.equals(firewall.id) : firewall.id != null) return false;
      if (name != null ? !name.equals(firewall.name) : firewall.name != null) return false;
      if (status != null ? !status.equals(firewall.status) : firewall.status != null) return false;
      if (tenantId != null ? !tenantId.equals(firewall.tenantId) : firewall.tenantId != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = id != null ? id.hashCode() : 0;
      result = 31 * result + (tenantId != null ? tenantId.hashCode() : 0);
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (description != null ? description.hashCode() : 0);
      result = 31 * result + (adminStateUp ? 1 : 0);
      result = 31 * result + (status != null ? status.hashCode() : 0);
      result = 31 * result + (firewallPolicyId != null ? firewallPolicyId.hashCode() : 0);
      return result;
   }

   @Override
   public String toString() {
      return "Firewall{" +
              "id='" + id + '\'' +
              ", tenantId='" + tenantId + '\'' +
              ", name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", adminStateUp=" + adminStateUp +
              ", status='" + status + '\'' +
              ", firewallPolicyId='" + firewallPolicyId + '\'' +
              '}';
   }

   public static Builder builder() {
      return new Builder();
   }

   public Builder toBuilder() {
      return new Builder().fromFirewall(this);
   }

   public static class Builder {
      protected String id;
      protected String tenantId;
      protected String name;
      protected String description;
      protected boolean adminStateUp;
      protected String status;
      protected String firewallPolicyId;

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

      public Builder adminStateUp(boolean adminStateUp) {
         this.adminStateUp = adminStateUp;
         return this;
      }

      public Builder status(String status) {
         this.status = status;
         return this;
      }

      public Builder firewallPolicyId(String firewallPolicyId) {
         this.firewallPolicyId = firewallPolicyId;
         return this;
      }

      public Firewall build() {
         return new Firewall(id, tenantId, name, description, adminStateUp, status, firewallPolicyId);
      }

      public Builder fromFirewall(Firewall in) {
         return this
                 .id(in.getId())
                 .tenantId(in.getTenantId())
                 .name(in.getName())
                 .description(in.getDescription())
                 .adminStateUp(in.isAdminStateUp())
                 .status(in.getStatus())
                 .firewallPolicyId(in.getFirewallPolicyId());
      }
   }

}
