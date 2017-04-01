<?php

Class dao{

	private $host = "localhost";
	private $db = "cgoetz";
	private $user = "cgoetz";
	private $password = "flickumbicus";

	public function getConnection () {
		$conn = new PDO("mysql:host={$this->host};dbname={$this->db}", $this->user, $this->password);
		$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); #causes erros to throw exceptions
		return $conn;
	}

	public function saveComment ($comment) {
		$conn = $this->getConnection();
		$saveQuery = "INSERT INTO comment (comment) VALUES (:comment)";
		$q = $conn->prepare($saveQuery);
		$q->bindParam(":comment", $comment);
		$q->execute();
	}

	public function getComments () {
		$conn = $this->getConnection();
		return $conn->query("SELECT * FROM comment");
	}

	public function validateUser($email, $pass) {
		$_SESSION['status'] = "got to validateUser";
		$conn = $this->getConnection();
		$stmt = $conn->prepare("SELECT password FROM users WHERE email = :email;");
		$stmt->bindParam(":email", $email);
		$stmt->execute();
		$result = $stmt->fetch();
		if($this->passwordVerify($pass, $result['password'])) {
			return true;
		} else {
			return false;
		}
	}

	public function passwordVerify($givenPassword, $userPassword){
		$_SESSION['status'] = "got to passwordVerify";
		if(empty($givenPassword) || empty($userPassword)){
			return false;
		} if($givenPassword == $userPassword) {
			return true;
		}
	}

	public function addUser($firstname, $lastname, $email, $pass) {
		$conn = $this->getConnection();
		$stmt = $conn->prepare("INSERT INTO users (password, first_name, last_name, email) VALUES (:password, :first_name, :last_name, :email)");
		$stmt->bindParam(":first_name", $firstname);
		$stmt->bindParam(":last_name", $lastname);
		$stmt->bindParam(":email", $email);
		$stmt->bindParam(":password", $pass);
		$stmt->execute();
		return true;
	}
}
