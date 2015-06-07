<form action="formside.php" method="post">
<input type="text" name="firstname" placeholder="Enter your name"/>
<br/>
Grade
<select>
<option>A</option>
<option>B</option>
<option>C</option>
<option>D</option>
<option>E</option>
</select>
</br></br>
Interests
<input type="checkbox" name="interest"value="sports"/>Sports
<input type="checkbox" name="interest"value="music"/>Misic

<input type="radio" name="gender" value="f"/>Female
<input type="radio" name="gender" value="m"/>Male


<input type="submit" value="submit"/>
</form>
<style> input[type="text"]{
	height: 30px;
	outline: none;
	border: 1px solid black;
	padding-left: 5px;
	border-radius: 2px;
	}
	</style>

