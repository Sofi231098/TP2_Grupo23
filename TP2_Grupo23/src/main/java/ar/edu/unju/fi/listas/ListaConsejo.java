package ar.edu.unju.fi.listas;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Consejo;

@Component
public class ListaConsejo {
	private List<Consejo> consejos;
	
	public ListaConsejo() {
		consejos = new ArrayList<Consejo>();
		consejos.add(new Consejo("Bañar a tu perro.", "Que tu peludo goce de una buena salud también dependerá de que lo mantengas limpio, libre de pulgas y garrapatas. En el caso de los perros, se recomienda dar un buen cepillado el cual dependerá del pelo de tu mascota y del baño. “Es importante bañar a tu perro una vez al mes usando productos para él, pues su pH es diferente del tuyo. Por su seguridad y bienestar no utilices con él productos para humanos: ni champú ni crema dental”"));
        consejos.add(new Consejo("Alimentacion acorde para tu mascota.", "Sea cual sea el tipo de comida que le vas a dar, asegúrate de elegirla con ayuda de tu veterinario y de brindarle una alimentación sana y balanceada. Siempre debe tener agua fresca y limpia y es importante que laves sus platos diariamente."));
        consejos.add(new Consejo("Dale una identidad a tu mascota.","Asegúrate de identificar muy bien a tu peludito ya sea con una placa que contenga el nombre de tu mascota y tus datos de contacto o a través de opciones como el microchip, el cual es una cápsula pequeña (del tamaño de un grano de arroz) que se implanta debajo de la piel y contiene un código único, que permite identificarlos con facilidad en el caso de que se extravie."));
        consejos.add(new Consejo("Ejercicio para peludos.", "Independientemente de su raza todos los perros y gatos necesitan ejercicio, por lo que es importante buscar opciones de diversión a su lado. En el caso de los perros, contempla opciones como trotar a su lado, jugar con la pelota o con un frisby… ¿Y los gatos? Una buena idea es darle juguetes llamativos (bolas de ping pong o ratones de tela) para que interactúen con ellos."));
        consejos.add(new Consejo("Proporcionar un espacio exclusivo para el descanso de tu mascota.", "Así como los seres humanos necesitamos un hogar en el que podamos sentirnos cómodos y seguros, también lo necesitan nuestras mascotas. Es recomendable porporcionar una cama del tamaño adecuado para tu mascota. Consejo clave: las mascotas que son demasiado jóvenes o ya tienen varios años encima pierden su capacidad para regular la temperatura corporal eficientemente. Es importante ofrecerles una manta y una cama que les proporcione confort y calor. Sobre todo en las horas de la noche."));
        consejos.add(new Consejo("Aplica las vacunas a tiempo.","Poco después de llegar a tu hogar, la primera salida debe ser al veterinario. Acto seguido se establecerá un calendario de vacunación para tu pequeño cachorro o gatito. Esto, con el objetivo de protegerlos de enfermedades como la rabia o el moquillo en el caso de los perros. Los gatos también se benefician de las vacunas que previenen el virus del herpes felino, la leucemia felina y la rabia. Consejo clave: si adoptaste una mascota en edad avanzada, asegúrate de que también esté protegido. Las vacunas necesitan renovación y no son solo para mascotas jóvenes."));
        consejos.add(new Consejo("Busca juguetes seguros.","Desecha y reemplaza los juguetes que estén gastados. Los juguetes chillones pueden proporcionar mucho entretenimiento para tu perro. Es importante que el dispositivo que proporciona el sonido no se pueda arrancar del juguete. Este objeto puede ser ingerido fácilmente, causando que termines por visitar el veterinario. Asimismo, no olvides eliminar los juguetes con partes sueltas que puedan presentar peligro de asfixia y bordes duros o afilados que podrían causar lesiones. Consejo clave: Evita los juguetes demasiado pequeños, estos pueden tragarse fácilmente o alojarse en la garganta. Los juguetes de peluche son buenos para varios propósitos. En ocasiones suelen ser de gran utilidad para incluirlos como recompensa en un esquema de entrenamiento; sin embargo, estos deben utilizarse con precaución."));
        consejos.add(new Consejo("Buscar un veterianrio de confianza.","Tener una mascota de manera responsable comienza con visitas regulares al veterinario. Dada su esperanza de vida, tu perrito mínimo deberían hacerse un chequeo una o dos veces al año. Pero el establecer y mantener la buena salud de tu mascota significa mantenerse al día con las visitas al veterinario a medida que envejecen. Es importante que busques un profesional que se encargue del cuidado y la salud de tu mascota, se recomienda buscar un veterinario profesional y con experiencia comprobada. Es importante que el veterinario atienda en una zona cercana a la vivienda de la mascota y que se pueda tener acceso y comunicación con él de manera permanente. Consejo clave: antes de salir camino hacia el veterinario, sácalos de paseo. Esto se hace para que no asocien entrar al carro con ir al veterinario."));
	}
	
	public List<Consejo> getConsejos(){	
		return consejos;
	}

	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}

	
	

	
}