package com.demo.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        // This runs the main application
        SpringApplication.run(Main.class, args);
    }

    // decorators starting with "*Mapping" indicates that these methods will be exposed to the port
    @GetMapping("/")
    public String home() {
        return "<h1>ceci est ma page d'accueil!</h1>";
    }

    // This method returns a JSON response. We did this, just by using MyRestResponse as the return type for this method
    @GetMapping("/sample_rest")
    public MyRestResponse sample() {
        return new MyRestResponse("ceci est une réponse en REST");
    }

    // Then we used this line to introduce the return type mentioned in the above method
    record MyRestResponse(String sample) {
    }

    // This method is the same as above but this time it returns an integer
    @GetMapping("/base_api")
    public BaseApiResponse baseApiResponse() {
        return new BaseApiResponse(42);
    }

    record BaseApiResponse(Integer baseApiResponse) {
    }


    // This method is the same as both of the above methods but does not use "record" to return the response of and URL
    // The ClassApiResponse method have the same syntax and structure as the above methods
    @GetMapping("/class_api_route")
    public ClassApiResponse classApiResponse() {
        return new ClassApiResponse("quelque chose");
    }

    // instead of using "record", we have created a class here.
    // this class signifies the data that we are passing as a response
    class ClassApiResponse {
        // this private variable is the data which we will pass as a response.
        private final String classApiResponse;

        // constructor method for this class
        ClassApiResponse(String classApiResponse) {
            this.classApiResponse = classApiResponse;
        }

        // getter method. This is important to export the data from this class otherwise data will not be returned as a response
        public String getClassApiResponse() {
            return classApiResponse;
        }

        // method to convert the data to string
        @Override
        public String toString() {
            return "ClassApiResponse{" +
                    "classApiResponse='" + classApiResponse + '\'' +
                    '}';
        }

        // overrides the method to check equality of two ClassApiResponse objects.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClassApiResponse that = (ClassApiResponse) o;
            return Objects.equals(classApiResponse, that.classApiResponse);
        }

        // overrides the method to convert the data to hashcode
        @Override
        public int hashCode() {
            return Objects.hash(classApiResponse);
        }
    }

    // This method is used to return a complete JSON packet as a response
    @GetMapping("/fruitstore_api")
    public JSONApiResponse jsonApiResponse() {
        return new JSONApiResponse(
                // first element is a simple string
                "Super Fruit Store",
                // second element is a list of strings
                List.of("Apple","Banana","Kiwi","Watermelon"),
                // third element is a custom object which is basically a string
                new Address("221-B", 18, "BakerStreet")
                );
    }

    // record object for custom object to be included in the json package
    record Address (String house, Integer streetNo, String streetName){}

    // this is the response that will be returned. the elements inside it will be used to determine the type of the
    // elements to fit into this json packet
    record JSONApiResponse(
            String jsonApiResponse,
            List<String> listOfFruits,
            Address address
            ) {
    }
}