Feature: Create Product 

	Background: Launch website and go to create product page
		Given Launch the website
		And Click on "Create Product" button
		
	Scenario: Product details should be visible after created
		When Enter the following data in the boxes
			|boxes			|data			|
			|productId		|1				|
			|description	|black cap		|
			|price			|5.90			|
			|imageUrl		|https://www.siparisverelim.com/Uploads/UrunResimleri/Thumb/siyah-snapback-hiphop-cap-sapka-modeller-610e.jpg |
		And Hit submit button
		Then Product details table should be visible