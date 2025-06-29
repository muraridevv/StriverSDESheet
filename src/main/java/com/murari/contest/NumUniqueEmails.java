package com.murari.contest;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
  public int numUniqueEmails(String[] emails) {
    Set<String> uniqueEmail = new HashSet<>();

    for (String email : emails) {
      String[] parts = email.split("@");
      String local = parts[0];
      String domain = parts[1];
      if (local.contains("+")) local = local.substring(0, local.indexOf("+"));
      local = local.replace(".", "");
      uniqueEmail.add(local + "@" + domain);
    }
    return uniqueEmail.size();
  }

  public static void main(String[] args) {
    //        String[] emails= new
    // String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
    String[] emails = new String[] {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
    NumUniqueEmails obj = new NumUniqueEmails();
    System.out.println(obj.numUniqueEmails(emails));
  }
}
