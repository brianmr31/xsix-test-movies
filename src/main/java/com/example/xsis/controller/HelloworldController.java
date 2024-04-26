package com.example.xsis.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xsis.dto.MessageRes;

@RestController
public class HelloworldController {
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/v1/Hello")
    public MessageRes getHello(){
        return new MessageRes("Hello World");
    }

    @GetMapping("/api/v1/Hello3")
    public int[] getTest2(){
        int[] input = {10, 30, 20, 40};
        int[] output = new int[2];

        for(int j=0; j < input.length; j++ ){
            for(int i=0; i < input.length; i++ ){
                if( i < (input.length - 1 ) ){
                    if( input[i] > input[i+1] ){
                        int tmp = input[i];
                        input[i] = input[i+1];
                        input[i+1] = tmp;
                    }
                }
            }
        }

        output[0] = input[input.length - 1];
        output[1] = input[input.length - 2];

        return output;
    }

    @GetMapping("/api/v1/Hello2")
    public MessageRes getTest(){
        double pinjaman = 30000000;
        int tenor = 10;

        double cicilanPokok = pinjaman / (tenor * 12 );
        System.out.println("|> "+cicilanPokok);

        int tmpTenorBulan = 0 ;
        int tmpTahunDlmTenor = 1;
        // float bunga = 0.5f;
        double bunga = 0.5 * ( 10 / 120 );
        System.out.println( bunga );
        double cicilanBungaPerBulan = 1;
        double cicilanKprPerBulan = 0;
        // for( int i=0; i < (tenor * 12); i++ ){

        //     if( tmpTenorBulan < ( 5 * 12 ) ){
        //         bunga = 0.5;
        //     } else {
        //         bunga = 0.8;
        //     }
            
        //     if( tmpTenorBulan % 12 == 0 ) {
        //         tmpTahunDlmTenor += 1;
        //     }

        //     cicilanBungaPerBulan = pinjaman * bunga * ( tenor / (tenor * 12));
        //     System.out.println( cicilanBungaPerBulan+" "+bunga+" "+ tenor);
        //     cicilanKprPerBulan = cicilanBungaPerBulan + cicilanPokok;
        //     tmpTenorBulan+=1;

        //     System.out.println(cicilanKprPerBulan+" "+cicilanBungaPerBulan+" "+tmpTenorBulan+" "+tmpTahunDlmTenor);
        // }
        return new MessageRes("Hello World");
    }

}
