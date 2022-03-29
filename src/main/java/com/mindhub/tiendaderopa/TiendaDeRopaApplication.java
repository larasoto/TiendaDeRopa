package com.mindhub.tiendaderopa;

import com.mindhub.tiendaderopa.modelos.*;
import com.mindhub.tiendaderopa.repositorios.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TiendaDeRopaApplication {

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(TiendaDeRopaApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ClienteRepositorio clienteRepositorio, PrendaRepositorio prendaRepositorio, CompraRepositorio compraRepositorio, PrendaClienteRepositorio prendaClienteRepositorio) {
        return (args) -> {
            Cliente cliente = new Cliente("Lara", "Soto", "lara@hotmail.com",passwordEncoder.encode("lara") );
            clienteRepositorio.save(cliente);

            Cliente administrador = new Cliente("admin","admin","admin@admin.com", passwordEncoder.encode("1234"));
            clienteRepositorio.save(administrador);

            Compra compra = new Compra(TipoCompra.TARJETA, LocalDateTime.now(), 1500);
            compraRepositorio.save(compra);

            Prenda prenda = new Prenda("Remera loli", 200, 20, TipoArticulo.REMERAS, Arrays.asList("S", "M", "L", "XL", "XXL"), "ver");
            prendaRepositorio.save(prenda);

            Prenda carteraMarron = new Prenda("Cartera Adele de piel con compartimento para smartphone Color Marrón Claro", 1000, 10, TipoArticulo.MARROQUINERIA,Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647390548/cartera3marron_rcgmrp.jpg");
            prendaRepositorio.save(carteraMarron);

            Prenda carteraNegra = new Prenda("Bandolera Ginny de piel Color Negro", 1200, 12,TipoArticulo.MARROQUINERIA,Arrays.asList("Standard"), "https://res.cloudinary.com/gohansox/image/upload/v1647390393/cartera2negra_sitlww.jpg");
            prendaRepositorio.save(carteraNegra);

            Prenda carteraMarronclaro = new Prenda("Cartera Color Marrón Claro",5000,20,TipoArticulo.MARROQUINERIA,Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647390207/cartera1_lkvp9g.jpg");
            prendaRepositorio.save(carteraMarronclaro);

            Prenda carteraBlanca = new Prenda("Bandolera Ginny Color Blanco", 4000,15,TipoArticulo.MARROQUINERIA,Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647565247/carterablanca_auw9df.jpg");
            prendaRepositorio.save(carteraBlanca);

            Prenda cintoMarron = new Prenda("Cinto Cuero Organico Color Marrón", 900, 10, TipoArticulo.MARROQUINERIA,Arrays.asList("S","M"),"https://res.cloudinary.com/gohansox/image/upload/v1647391905/cintoMarron_yrw8ly.jpg");
            prendaRepositorio.save(cintoMarron);

            Prenda tarjeteroPiel = new Prenda("Tarjetero de piel granulada Color Negro", 5000, 5, TipoArticulo.MARROQUINERIA,Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647390710/cartera4negra_lpnf1a.jpg");
            prendaRepositorio.save(tarjeteroPiel);

            Prenda cintoBlanco = new Prenda("Cinto Square Buckle Color Blanco", 1500, 5, TipoArticulo.MARROQUINERIA,Arrays.asList("S","M"),"https://res.cloudinary.com/gohansox/image/upload/v1647391628/cintoBlanco_f3vdsp.jpg");
            prendaRepositorio.save(cintoBlanco);

            //indumentaria
            Prenda vestido1 = new Prenda("Vestido de encaje con estampado de palmeras Color Blanco",4000, 6,TipoArticulo.INDUMENTARIA, Arrays.asList("S","M","L","XL"),"https://res.cloudinary.com/gohansox/image/upload/v1647399422/vestido1_rtxvpk.jpg");
            prendaRepositorio.save(vestido1);

            Prenda vestido2 = new Prenda("Vestido de tirantes acanalado Color Negro",4500, 6,TipoArticulo.INDUMENTARIA, Arrays.asList("S","M","L"),"https://res.cloudinary.com/gohansox/image/upload/v1647399528/vestido2_oml5tt.jpg");
            prendaRepositorio.save(vestido2);

            Prenda joggers= new Prenda("Joggers Color Celeste Claro",3500, 10,TipoArticulo.INDUMENTARIA, Arrays.asList("XS","S","M","L"),"https://res.cloudinary.com/gohansox/image/upload/v1647399700/vestido3_okl6k6.jpg");
            prendaRepositorio.save(joggers);

            Prenda joggers2= new Prenda("Joggers Color Blanco",4000, 30,TipoArticulo.INDUMENTARIA, Arrays.asList("XS","S","M","XL"),"https://res.cloudinary.com/gohansox/image/upload/v1647399785/joggers2_igxecl.jpg");
            prendaRepositorio.save(joggers2);

            Prenda vestido4= new Prenda("Vestido midi de georgette Color Negro",4000, 6,TipoArticulo.INDUMENTARIA, Arrays.asList("S","M"),"https://res.cloudinary.com/gohansox/image/upload/v1647400056/vestido4_q3365c.jpg");
            prendaRepositorio.save(vestido4);

            Prenda vestido5= new Prenda("Vestido acanalado Color Negro",3250, 6,TipoArticulo.INDUMENTARIA, Arrays.asList("S","M","L","XXL"),"https://res.cloudinary.com/gohansox/image/upload/v1647570179/niggawhaaaat_ygrtiq.jpg");
            prendaRepositorio.save(vestido5);

            Prenda camiseta = new Prenda("Camiseta de tirantes acanalada Color Beige",3000, 6,TipoArticulo.INDUMENTARIA, Arrays.asList("XS","S","M"),"https://res.cloudinary.com/gohansox/image/upload/v1647401195/camiseta1_jesj7h.jpg");
            prendaRepositorio.save(camiseta);

            Prenda camiseta2 = new Prenda("Camiseta de tirantes acanalada Color Morado",3000, 6,TipoArticulo.INDUMENTARIA, Arrays.asList("XS","S"),"https://res.cloudinary.com/gohansox/image/upload/v1647401308/camiseta2_tnz3yh.jpg");
            prendaRepositorio.save(camiseta2);

            //zapatos!
            Prenda zapatoMarron = new Prenda("Sandalia Kelli con adornos y logotipo", 12000, 14, TipoArticulo.ZAPATOS,Arrays.asList("8","9","10","11","12"),"https://res.cloudinary.com/gohansox/image/upload/v1647385330/zapatos3_k2zlct.jpg" );
            prendaRepositorio.save(zapatoMarron);

            Prenda zapatoNegro = new Prenda("Zapato de salón Keke de piel con tachuelas", 13500, 15, TipoArticulo.ZAPATOS, Arrays.asList("11","12"),"https://res.cloudinary.com/gohansox/image/upload/v1647385158/zapatos2_dpuzvr.jpg");
            prendaRepositorio.save(zapatoNegro);

            Prenda zapatoCamel = new Prenda("Zapato de salón Kadence",15000,5,TipoArticulo.ZAPATOS, Arrays.asList("8","9","10","11"),"https://res.cloudinary.com/gohansox/image/upload/v1647384607/zapatos1_jaqaxv.jpg");
            prendaRepositorio.save(zapatoCamel);

            Prenda zapato4 = new Prenda("Zapato de salón Keke de piel con tachuelas",17000,3,TipoArticulo.ZAPATOS, Arrays.asList("8","9","10","11"),"https://res.cloudinary.com/gohansox/image/upload/v1647385534/zapatos4_wr95ea.jpg");
            prendaRepositorio.save(zapato4);

            Prenda zapato5 = new Prenda("Zapato de salón Dorothy de piel",11540,6,TipoArticulo.ZAPATOS, Arrays.asList("8","9","10","11"),"https://res.cloudinary.com/gohansox/image/upload/v1647385699/zapatos5_xukqg3.jpg");
            prendaRepositorio.save(zapato5);

            Prenda zapato6 = new Prenda("Sandalia tipo alpargata Laney de piel saffiano con cuña",10000,8,TipoArticulo.ZAPATOS, Arrays.asList("8","9","10","11"),"https://res.cloudinary.com/gohansox/image/upload/v1647386258/zapatos6_bidfqz.jpg");
            prendaRepositorio.save(zapato6);

            Prenda zapato7 = new Prenda("Zapatos de salón abiertos de satén la medusa",13000,2,TipoArticulo.ZAPATOS, Arrays.asList("8","9","10","11"),"https://res.cloudinary.com/gohansox/image/upload/v1647386547/zapatos7_cwfhty.jpg");
            prendaRepositorio.save(zapato7);

            Prenda zapato8 = new Prenda("Sandalia Wren de piel en relieve metalizada con motivo de serpiente y tachuelas",14000,4,TipoArticulo.ZAPATOS, Arrays.asList("8","9","10","11"),"https://res.cloudinary.com/gohansox/image/upload/v1647386845/zapatos8_bc18fs.jpg");
            prendaRepositorio.save(zapato8);

            Prenda zapato9 = new Prenda("Sandalia Giselle de piel en relieve con cristales",13500,4,TipoArticulo.ZAPATOS, Arrays.asList("8","9","10","11"),"https://res.cloudinary.com/gohansox/image/upload/v1647387001/zapatos9_iehenq.jpg");
            prendaRepositorio.save(zapato9);

            //Joyeria
            Prenda collar1 = new Prenda("Collar de plata de ley con chapado en oro rosa de 14 K y piedra",8000,6,TipoArticulo.JOYERIA, Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647398253/collar1_phain5.jpg");
            prendaRepositorio.save(collar1);

            Prenda collar2 = new Prenda("Set de collar con corazón y pendientes con cierre de tuerca de plata",10000,3,TipoArticulo.JOYERIA, Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647398597/collar2_azhkwz.jpg");
            prendaRepositorio.save(collar2);

            Prenda pulsera1 = new Prenda("Pulsera de plata de ley con cierre deslizante", 6000,7,TipoArticulo.JOYERIA, Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647398717/pulsera1_xvf33d.jpg");
            prendaRepositorio.save(pulsera1);

            Prenda pulsera2 = new Prenda("Pulsera rígida de plata", 4500,4,TipoArticulo.JOYERIA, Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647398796/pulsera2_wrbwxq.jpg");
            prendaRepositorio.save(pulsera2);

            Prenda aros1 = new Prenda("Pendientes de plata", 4500, 5, TipoArticulo.JOYERIA,Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647398970/aros1_dbvblr.jpg");
            prendaRepositorio.save(aros1);

            Prenda aros2 = new Prenda("Pendientes largos de plata", 4500, 5, TipoArticulo.JOYERIA,Arrays.asList("Standard"),"https://res.cloudinary.com/gohansox/image/upload/v1647399047/aros2_x36ozy.jpg");
            prendaRepositorio.save(aros2);

            //remeras
            Prenda remeraBlanca = new Prenda("Remera Blanca",2000,5,TipoArticulo.REMERAS,Arrays.asList("S","M","L"),"ver");
            prendaRepositorio.save(remeraBlanca);

            Prenda remeraNegra = new Prenda("Remera Negra", 4800,7,TipoArticulo.REMERAS,Arrays.asList("XS","S","M","L","XL"),"ver");
            prendaRepositorio.save(remeraNegra);


/*            Set<Prenda> prendas = new HashSet<>();
            prendas.add(prenda);*/
            PrendaCliente prendaCliente = new PrendaCliente(prenda,100,500, compra, cliente);
            prendaClienteRepositorio.save(prendaCliente);
        };
    }
}