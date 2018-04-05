/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author Yash
 */
public class UserProfile
{
   private static String userName;
   private static String password;
   private static String userType;

    /**
     * @return the userName
     */
    public static String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public static void setUserName(String userName) {
        UserProfile.userName = userName;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public static void setPassword(String password) {
        UserProfile.password = password;
    }

    /**
     * @return the userType
     */
    public static String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public static void setUserType(String userType) {
        UserProfile.userType = userType;
    }
   
}