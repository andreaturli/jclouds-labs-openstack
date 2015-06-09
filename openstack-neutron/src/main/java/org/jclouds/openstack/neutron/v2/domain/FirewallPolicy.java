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
import java.util.List;

import javax.inject.Named;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * A firewall policy
 *
 * @see <a
 *      href="http://docs.openstack.org/admin-guide-cloud/content/fwaas_api_abstractions.html">api doc</a>
 */
public class FirewallPolicy {

   private String id;
   @Named("tenant_id")
   private String tenantId;
   @Named("name")
   private String name;
   @Named("description")
   private String description;
   @Named("shared")
   private boolean shared;
   @Named("firewall_rules")
   private List<String> firewallRules;
   @Named("audited")
   private boolean audited;

   @ConstructorProperties({"id", "tenant_id", "name", "description", "shared", "firewall_rules", "firewall_policy_id"})
   protected FirewallPolicy(String id, String tenantId, String name, String description, boolean shared, List<String> firewallRules, boolean audited) {
      this.id = id;
      this.tenantId = tenantId;
      this.name = name;
      this.description = description;
      this.shared = shared;
      this.firewallRules = firewallRules == null ? ImmutableList.<String>of() : ImmutableList.copyOf(firewallRules);
      this.audited = audited;
   }

   private FirewallPolicy() {}

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

   public boolean isShared() {
      return shared;
   }

   public List<String> getFirewallRules() {
      return firewallRules;
   }

   public boolean isAudited() {
      return audited;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof FirewallPolicy)) return false;

      FirewallPolicy that = (FirewallPolicy) o;

      if (audited != that.audited) return false;
      if (shared != that.shared) return false;
      if (description != null ? !description.equals(that.description) : that.description != null) return false;
      if (firewallRules != null ? !firewallRules.equals(that.firewallRules) : that.firewallRules != null) return false;
      if (id != null ? !id.equals(that.id) : that.id != null) return false;
      if (name != null ? !name.equals(that.name) : that.name != null) return false;
      if (tenantId != null ? !tenantId.equals(that.tenantId) : that.tenantId != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = id != null ? id.hashCode() : 0;
      result = 31 * result + (tenantId != null ? tenantId.hashCode() : 0);
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (description != null ? description.hashCode() : 0);
      result = 31 * result + (shared ? 1 : 0);
      result = 31 * result + (firewallRules != null ? firewallRules.hashCode() : 0);
      result = 31 * result + (audited ? 1 : 0);
      return result;
   }

   @Override
   public String toString() {
      return "FirewallPolicy{" +
              "id='" + id + '\'' +
              ", tenantId='" + tenantId + '\'' +
              ", name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", shared=" + shared +
              ", firewallRules=" + firewallRules +
              ", audited=" + audited +
              '}';
   }

   public static Builder builder() {
      return new Builder();
   }

   public Builder toBuilder() {
      return new Builder().fromFirewallPolicy(this);
   }

   public static class Builder {
      protected String id;
      protected String tenantId;
      protected String name;
      protected String description;
      protected boolean shared;
      protected List<String> firewallRules = Lists.newArrayList();
      protected boolean audited;

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

      public Builder shared(boolean shared) {
         this.shared = shared;
         return this;
      }

      public Builder firewallRules(List<String> firewallRules) {
         this.firewallRules.addAll(firewallRules);
         return this;
      }

      public Builder audited(boolean audited) {
         this.audited = audited;
         return this;
      }

      public FirewallPolicy build() {
         return new FirewallPolicy(id, tenantId, name, description, shared, firewallRules, shared);
      }

      public Builder fromFirewallPolicy(FirewallPolicy in) {
         return this
                 .id(in.getId())
                 .tenantId(in.getTenantId())
                 .name(in.getName())
                 .description(in.getDescription())
                 .shared(in.isShared())
                 .firewallRules(in.getFirewallRules())
                 .audited(in.isAudited());
      }
   }

}
