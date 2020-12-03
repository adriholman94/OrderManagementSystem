package com.fiuni.sd.beans;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserRoles")
public class UserRole implements BaseBean {

   /**
   *
   */
  private static final long serialVersionUID = 1L;
  
  @Id
   @ManyToOne
   @JoinColumn(name = "userId")
   private User user;

   @Id
   @ManyToOne
   @JoinColumn(name = "roleId")
   private Role role;

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public Role getRole() {
      return role;
   }

   public void setRole(Role role) {
      this.role = role;
   }
   
}