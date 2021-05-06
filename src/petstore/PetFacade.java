/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;
import java.rmi.Remote ;
import java.rmi.RemoteException ;
import java.util.List ;

/**
 *
 * @author macair
 */
public interface PetFacade extends Remote{
    Pet findPet(Pet p) throws RemoteException ;
    List<Pet> getAllPets() throws RemoteException ;
    
    
}

