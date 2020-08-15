package br.edu.ifsp.arq.dmos5_2020s1.loginhardcode.model;


public class Usuario {

    private static final int PRONTUARIO = 3003205;
    private static final int SENHA = 5023003;

    private int prontuario;
    private int senha;

    public Usuario(int prontuario, int senha){
       this.prontuario = prontuario;
       this.senha = senha;
    }

    public static int getPRONTUARIO() {
        return PRONTUARIO;
    }

    public boolean realizaLogin() {

        if(prontuario == getPRONTUARIO() && senha == SENHA){
            return true;
        }else{
            return false;
        }
    }
}
