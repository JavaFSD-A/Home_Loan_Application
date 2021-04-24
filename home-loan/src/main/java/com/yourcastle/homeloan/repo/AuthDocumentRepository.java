/**
* 
* 
*@author Anju 
* 
*/

package com.ibm.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.loan.entity.AuthDocument;

public interface AuthDocumentRepository extends JpaRepository<AuthDocument, Integer> {

}