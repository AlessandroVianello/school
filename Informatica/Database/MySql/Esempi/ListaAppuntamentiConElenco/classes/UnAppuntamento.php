<?php

class UnAppuntamento {

    private $errore = array("mancaDato" => "Manca Dato: ",
        "dataErrata" => "Data errata");
    // variabili membro
    protected $descrizione;
    protected $data;
    protected $strErrore;
    protected $numErrori;
    protected $isOK;

    // costruttore
    public function __construct($desc, $data) {
        $this->descrizione = $desc;
        $this->data = $data;
        $this->controllaDati();
    }

    private function dataValida($data) {
        //va inserito controllo espressioni regolari e va migliorasto il controllo       
        $arrayData = explode("/", $data);
        if (count($arrayData) != 3) return false;
        $giorno = intval($arrayData[0],10);
        $mese = intval($arrayData[1], 10);
        $anno = intval($arrayData[2], 10);
        return checkdate($mese, $giorno, $anno);
    }
    
    public function getDescrizione() {
        return $this->descrizione;
    }

    public function setDescrizione($desc) {
        $this->descrizione = $desc;
    }

    public function getData() {
        return $this->data;
    }

    public function setData($data) {
        $this->data = $data;
    }

    public function datiOk() {
        return $this->isOK;
    }

    public function getStrErrori() {
        return $this->strErrore;
    }

    private function controllaDati() {
        $month = 0;
        $day = 0;
        $year = 0;
        $numErrori = 0;
        $isOK = true;
        $this->strErrore = "";
        if (!isset($this->descrizione) || empty($this->descrizione)) {
            $this->addErrore($this->errore["mancaDato"] . " descrizione");
        }
        if (!isset($this->data) || empty($this->data)) {
            $this->addErrore($this->errore["mancaDato"] . " data");
        } else {
            if (!$this->dataValida($this->data)) {
                $this->addErrore($this->errore["dataErrata"]);
            }
        }
        if ($this->numErrori == 0)
            $this->isOK = true;
        else
            $this->isOK = false;
        return $this->isOK;
    }

    private function addErrore($err) {
        $this->numErrori++;
        if ($this->numErrori == 1) {
            $this->strErrore = $err;
        } else
            $this->strErrore = $this->strErrore . " e Altri errori";
    }

}

?>
