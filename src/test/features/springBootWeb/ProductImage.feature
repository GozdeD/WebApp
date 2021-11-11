Feature: Product Image Visibility Test 

	Background: Launch web site
		Given Launch web site
		And Click on the "Products" button
		
	Scenario: Product Image should be visible for the first product after navigating to the product image url
		When Click on the "View" link for first product
		And Copy Image Url and go to the url
		Then The product image should be visible
		
	Scenario:Product Image should be visible for the second product after navigating to the product image url
		When Click on the "View" link for second product
		And Copy Image Url and go to url
		Then The product image is visible