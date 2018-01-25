<?php

class ListaAppuntamenti {

    protected $lista;

    public function indiceValido($i) {
           if (($i >= 0) && ($i < count($this->lista))) return TRUE;
           else return FALSE;
    }
    
    // costruttore
    public function __construct() {
        $this->lista = array();
        unset( $this->posApp);
    }
    
    public function aggiungi(UnAppuntamento $a) {
        $this->lista[] = $a;
    }

    public function elimina($i) { //elimina l'i-esimo appuntamento
        if (self::indiceValido($i)) {
            array_splice($this->lista, $i, 1);
        }
    }

    public function eliminaTutti() {
        array_splice($this->lista, 0, count($this->lista));
    }

    public function modifica($i, UnAppuntamento $a) {
        if (self::indiceValido($i)) {
            $this->lista[$i] = $a;
            return TRUE;
        } else
            return FALSE;
    }

    public function sposta($p1, $direz) { // sistemare controlli
        $p1 = intval($p1, 10);
        $p2 = $p1 + 1;
        if (self::indiceValido($p1)) {
            if (strcmp($direz, "su") == 0) {
                $p2 = $p1 - 1;
            }
            $app = $this->lista[$p1];
            $this->lista[$p1] = $this->lista[$p2];
            $this->lista[$p2] = $app;
        }
    }

    public function getLista() {
        return $this->lista;
    }
    
    public function getAppuntamento($i){
        return $this->lista[$i];
    }
    
    public function setAppuntamento ($appuntamento, $i) {
        if (self::indiceValido($i)) {
            $this->lista[$i] = $appuntamento;
            return TRUE;
        } else return FALSE;
    }

}

?>
