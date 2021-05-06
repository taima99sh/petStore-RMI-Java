/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;
import java.rmi.RemoteException ;
import java.rmi.registry.Registry ;
import java.rmi.registry.LocateRegistry ;
import java.rmi.server.UnicastRemoteObject ;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macair
 */
public class PetStoreServer extends UnicastRemoteObject implements PetFacade {
    
    private List<Pet> petList ;

    public PetStoreServer(List<Pet> petList) throws RemoteException{
        super() ;
        this.petList = petList ;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT) ;
            PetStoreServer store = new PetStoreServer(init()) ;
            reg.rebind("rmi://localhost/service", store);
            System.out.println("pet store server running ......");
            
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Pet findPet(Pet p) throws RemoteException {
        Predicate<Pet> predicate = x -> x.getCode().equals(p.getCode()) ;
        Pet response = petList.stream().filter(predicate).findFirst().get() ;
        return response ;
    }

    @Override
    public List<Pet> getAllPets() throws RemoteException {
        return petList ;
    }
    
    private static List<Pet> init() {
        List<Pet> list = new ArrayList<>();
        list.add(new Pet("cat 1", "c1", 44.5)) ;
        list.add(new Pet("dog 2", "d1", 44.5)) ;
        list.add(new Pet("cat 2", "c1", 44.5)) ;
        list.add(new Pet("dog 2", "d2", 44.5)) ;
        return list ; 
    }
    
}
