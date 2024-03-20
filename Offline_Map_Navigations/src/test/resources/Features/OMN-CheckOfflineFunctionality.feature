@Offlineregression
Feature: To validate the Check  Offline OMN-App functionality.


  @offlinebase
  Scenario: To validate Offline Base File functionality
    Given UserAO can first select language
    When UserAO can click  apply button
    And UserAO can click next the option
    And UserAO can click  continues button
   # And UserAO Can click  I will do it Later
    And UserAO can click  allow button
    And UserAO can download the offline bundle
    And UserAO can click the Get Started button
    And UserAO can verify the Loading page
    
    
    @Offlinelanguages
    Scenario: To validate offline  Languages functionality
    Given UserLO can login OMN Application
    When UserLO can click the menu
    When UserLO can click the settings
    When UserLO can click the languages
    And UserLO can Verify All the languages
    
    
    @Offlineomn
  Scenario: To validate Offline Map Navigation functionality
   Given UserBO can login OMN Application
    When UserBO Click the user location
    And UserBO Verify the user Location
    And UserBO can search any areas
    And UserDO can Choose destination areas
    And UserDO can click the search area
    And UserDO Can verify the destination point
  
    
    When UserPO can click the Places option
    And UserPO can click the POI option
    And UserPO can check Food POI option and click restaurant
    And UserPO can verify the restaurant
    And UserPO Can click Cafe and verify the cafe
    And userPO can click the Fast Food and verify the Fast Food
    And userPO can click the Hospital and verify hospital
    And userPO can click the Pharmacy and verify pharmacy
    And userPO can click the Supermarket and verify
    And userPO can click the department store and verify
    And userPO can click the General and verify
    And userPO can click the car repair and verify
    And userPO can click the cars and verify
    And userPO can click the Mall and verify
    And UserPO can click the Park and verify
    And UserPO can click the Stadium and verify
    #And UserPO can click the Marina and verify
    And UserPO can click the Sports Centre and verify
    And UserPO can click the Golf Course and verify
    And UserPO can click the Pitch and verify
    And UserPO can click the POI option
    And UserPO can click the Terminal and verify
    And UserPO can click the Aerodrome and verify
    And UserPO can click the Hotel and verify
    And UserPO can click the Government and verify
   # And UserPO can click the Embassy and verify
    And UserPO can click the Fire Station and verify
    And UserPO can click the Toilets and vetify
    And UserPO can click the School and verify
    #And USer can click the College and verify
   # And User can click the University and verify
    And UserPO can click the Libray and Verify
    And UserPO can click the Place Of Worship and verify
    And UserPO can click the Bus Stops and verify
    And UserPO can click the Fuel Station and verify
    And UserPO can click the Change Station
    And UserPO can click the Attraction and verify
    #And User can click the Museums and vertify
    And UserPO can click the Information and verify
    And UserPO can click the Hostels and verify
    
    When UserSO can search any areas
    And UserSO can Choose destination areas
    And userSO can click the save icon
    And UserSO Can Save Route Place
    And UserSO can verify Saved
    
    
 
    
 
    
    When UserFO can click the menu option
    And UserFO can click the setting buttton
    And UserFO can click the send feedback button
    And UserFO can enter good thing about app
    And UserFO can enter bad thing about app
    And UserFO can enter improvement
    And UserFO can enter issues about app
    And UserFO can enter contact email
    And UserFO can click the check box
    Then UserFO can click the send button
    
    
    
   #  When User click the menu option
   #  And User can click the download map
   #  And User can click Australia and Oceania
   #  And User can Download Marshall Isaland Map
   #  And User can Download Pitcain Island Map
   #  And User Can Download Nauru Map
   #  And User can verify map download or not
   #  And User can delete download maps
   #  And User can serach box
    
    
    When UserVO can click Voice Icon
    And UserVO can check voice working or not
     
     
  # When UserTO can POI direction in offline
     
  @offlinesearch   
  Scenario Outline: To validate Offline autocomplete search results for different Country...
 Given UserOAS can login OMN Application 
Then UserOAS search for "<Offlinearea>" in the search box

 Examples:
    | Offlinearea            |
      | salem           |
      | chennai         |
      | madurai         |
      | Coonoor         |
      | Coimbatore      |
      | Kanchipuram     |
      | Kanyakumari     |
      | Rameswaram      |
      | madurai         |
      | Tiruchirappalli |
      | Vellore         |
      | Ooty            |

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     