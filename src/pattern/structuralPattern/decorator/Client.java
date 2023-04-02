/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structuralPattern.decorator;

/**
 *
 * @author Hung
 */
public class Client {
 
    public static void main(String[] args) {
        System.out.println("NORMAL EMPLOYEE: ");
        EmployeeComponent employee = new EmployeeConcreteComponent("NORMALEMPLOYEE");
        employee.showBasicInformation();
        employee.doTask(); // Làm công việc của nhân viên thường  
        
        System.out.println("\n TeamMember: ");      
        TeamMember member = new TeamMember(employee);
        member.showBasicInformation();
        member.doTask();// Làm công việc của normal employee và công việc của TeamMember
        
        System.out.println("\n TEAMMEMBER & TEAM LEADER: ");        
        EmployeeComponent leaderAndMember = new TeamLeader(member);
        leaderAndMember.showBasicInformation();
        leaderAndMember.doTask();// Làm công việc của TeamMember và công việc của TeamLeader
        
        System.out.println("\nTEAM LEADER: ");        
        EmployeeComponent teamLeader = new TeamLeader(employee);
        teamLeader.showBasicInformation();
        teamLeader.doTask(); // Làm công việc của normal employee và công việc của TeamLeader
 
             
        System.out.println("\nMANAGER: ");
        EmployeeComponent manager = new Manager(employee);
        manager.showBasicInformation();// Làm công việc của normal employee và công việc của Manager
        manager.doTask();
 
        System.out.println("\nTEAM LEADER AND MANAGER: ");
        EmployeeComponent teamLeaderAndManager = new Manager(teamLeader);
        teamLeaderAndManager.showBasicInformation();
        teamLeaderAndManager.doTask();
        
        System.out.println("\n  MANAGER AND MEMBER ");
        EmployeeComponent managerAndMember = new TeamMember(manager);
        managerAndMember.showBasicInformation();
        managerAndMember.doTask();
    }
}