


public class Cliente {
    
        private String nome;
        private String email;
        private String senha;
    
        public Cliente(String nome, String email, String senha) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
        }
    
        public Cliente(int int1, String string, String string2, String string3) {
        }

        public String getNome() {
            return nome;
        }
    
        public String getEmail() {
            return email;
        }
    
        public String getSenha() {
            return senha;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public void setSenha(String senha) {
            this.senha = senha;
        }
    
        public String toString() {
            return "Nome: " + nome + "\nEmail: " + email + "\nSenha: " + senha;
        }
    
        public static void main(String[] args) {
            try (java.util.Scanner input = new java.util.Scanner(System.in)) {
                System.out.print("Digite o nome do cliente: ");
                String nome = input.nextLine();
                System.out.print("Digite o email do cliente: ");
                String email = input.nextLine();
                System.out.print("Digite a senha do cliente: ");
                String senha = input.nextLine();
   
                Cliente cliente1 = new Cliente(nome, email, senha);
                System.out.println("\nInformações do cliente:");
                System.out.println(cliente1);
            }
        }

        public void setId(int int1) {
        }

        public int getId() {
            return 0;
        }
    }
    

