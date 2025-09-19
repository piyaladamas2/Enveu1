package com.piyal.enveuproject.Entity;

import java.util.List;
import java.util.ArrayList;

public class EndPointConfig {
  public static List<String> authUrls;
  public static List<String> superAdminUrls;
  public static List<String> adminUrls;
  public static List<String> userUrls;

  static {
    authUrls = new ArrayList<>();
    superAdminUrls = new ArrayList<>();
    adminUrls = new ArrayList<>();
    userUrls = new ArrayList<>();

    // allow all auth urls
    authUrls.add("/api/auth/register");
    authUrls.add("/api/auth/login");

    // super user admin urls
    superAdminUrls.add("/api/super-admin/admin");
    superAdminUrls.add("/api/super-admin/users/{id}/roles");
    superAdminUrls.add("/api/admin/users");
    superAdminUrls.add("/api/super-admin/users/{id}");
    superAdminUrls.add("/api/super-admin/users/{id}/password");
    superAdminUrls.add("/api/super-admin/users/{id}/roles");

    // adminUrls
    adminUrls.add("/api/admin/users");
    adminUrls.add("/api/super-admin/users/{id}");
    adminUrls.add("/api/super-admin/users/{id}/password");
    adminUrls.add("/api/super-admin/users/{id}/roles");

    // userUrls
    userUrls.add("/api/users/me");
    userUrls.add("/api/users/me/password");
    userUrls.add("/api/users/me/roles");

  }
}
