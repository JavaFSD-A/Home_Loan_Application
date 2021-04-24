/**
* 
* 
*@author Anju 
* 
*/

package com.yourcastle.homeloan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.AuthDocument;

public interface AuthDocumentRepository extends JpaRepository<AuthDocument, Integer> {

}