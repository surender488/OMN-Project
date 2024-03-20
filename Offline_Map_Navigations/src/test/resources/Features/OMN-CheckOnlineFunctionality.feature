#@regression
Feature: To validate the Check  Online OMN-App functionality.

  @basefile
  Scenario: To validate Online Base File functionality
    Given User can first select the  language
    When User can click  apply button
    And User can click next the option
    And User can click  continues button
    # And User Can click  I will do it Later
    And user can click  allow button
    And User can download the offline bundle
    And User can click the Get Started button


    And UserA can verify the Loading page

  @languages
  Scenario: To validate Languages functionality
    Given UserL can login OMN Application
    When UserL can click the menu
    When UserL can click the settings
    When UserL can click the languages
    And UserL can Verify All the languages

@omn
  Scenario: To validate  Map Navigation functionality
   Given UserB can login OMN Application
    When UserB Click the user location
     And UserB Verify the user Location
    When UserD can search any areas
    And UserD can Choose destination areas
    And UserD can click the search area
    And UserD Can verify the destination point
   ##When UserR can search any areas
   # And UserR can check Retry button
  #  And UserR can Check Report buttton
  
 #  When UserB Enter a Home Page
    #And UserB Click the Search Box
  #  And UserB Enter the Related Location in Search Box
  #  And UserB Validate the Locations  
    
    When User can click the Places option
    And User can click the POI option
    And User can check Food POI option and click restaurant
    And User can verify the restaurant
    And User Can click Cafe and verify the cafe
    And user can click the Fast Food and verify the Fast Food
    And user can click the Hospital and verify hospital
    And user can click the Pharmacy and verify pharmacy
    And user can click the Supermarket and verify
    And user can click the department store and verify
    And user can click the General and verify
    And user can click the car repair and verify
    And user can click the cars and verify
    And user can click the Mall and verify
    And User can click the Park and verify
    And User can click the Stadium and verify
    #And User can click the Marina and verify
    And User can click the Sports Centre and verify
    And User can click the Golf Course and verify
    And User can click the Pitch and verify
    And User can click the POI option
    And User can click the Terminal and verify
    And User can click the Aerodrome and verify
    And User can click the Hotel and verify
    And User can click the Government and verify
   # And User can click the Embassy and verify
    And User can click the Fire Station and verify
    And User can click the Toilets and vetify
    And User can click the School and verify
    #And USer can click the College and verify
   # And User can click the University and verify
    And User can click the Libray and Verify
    And User can click the Place Of Worship and verify
    And User can click the Bus Stops and verify
    And User can click the Fuel Station and verify
    And User can click the Change Station
    And User can click the Attraction and verify
    #And User can click the Museums and vertify
    And User can click the Information and verify
    And User can click the Hostels and verify
    
     When UserS can search any areas
    And UserS can Choose destination areas
    And userS can click the save icon
    And UserS Can Save Route Place
    And UserS can verify Saved
    
    
     When UserS can click the menu option
    And UserS can click the setting buttton
    And UserS can check Route Setting option
    And UserS can Check Language option
    And UserS can check Color Theme option
    And UserS can check Data pivacy option
    And UserS can check Privacy Policy option
    And UserS Can check Terms Of Use options
    And UserS can check Acknowledgements options
    And UserS can About Us Options
    And UserS can Send Feedback options
    And USerS can check Report Error options
    And UserS can check More Apps options
    And UserS Can Check for Updates options
    And UserS can check compass options
    
     When User can click the menu option
    And User can click the setting buttton
    And User can click the send feedback button
    And User can enter good thing about app
    And User can enter bad thing about app
    And user can enter improvement
    And User can enter issues about app
    And User can enter contact email
    And User can click the check box
    Then User can click the send button
    
    
    
    
    When UserV can click Voice Icon
    And UserV can check voice working or not
     
     
   #  When User can POI direction in offline
   
   @Search
   Scenario Outline: To validate Offline autocomplete search results for different Country...
 Given UserAS can login OMN Application 
 Then I search for "<area>" in the search box

 Examples:
      | area            |
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
   
   
   
   
   
   
   
   
   
   
   
   
   
 