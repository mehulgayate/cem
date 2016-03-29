<div class="popupContainer mfp-hide" id= "productReviewPopup">
	<div class="popupHeader">
	</div>
	<form action ="/product-review" method="post">
		   <div class="tableheader">
				Add Review
		   </div>
		
		<div style ="margin: 0;auto;">
		  <br/>
		  	
		  <div style="display: table;width: 300px; color: black;">			   
			   <div style="display: table-row;">
			      <div style="display: table-cell; padding: 4px;">
			         
			      </div>
				  <div>
			      	<textarea rows="15" cols="40" name="review"></textarea>				
			   	  </div>
			   	  <input type="hidden" name="searchString" value="${query!}">
			   	  <input type="hidden" name="productId" value="" id ="productId">
			   </div>
			   
			   </div>
			   
			</div>
        
      
	    <div class="popupFooter">
			<input type="submit" value="Save" class="buttonClassOne">	
	    </div>
	  </form>
</div>