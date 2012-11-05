package com.example.model;

public class User implements Comparable<User> {

  public String name;
  public String email;
  public String password;
  public String role;

  public User withName(String name) {
    this.name = name;
    return this;
  }

  public User withEmail(String email) {
    this.email = email;
    return this;
  }

  public User withPassword(String password) {
    this.password = password;
    return this;
  }

  public User withRole(String role) {
    this.role = role;
    return this;
  }

  @Override
  public String toString() {
    return "User [name=" + name + ", email=" + email + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public int compareTo(User other) {
    return this.name.compareTo(other.name);
  }

}
