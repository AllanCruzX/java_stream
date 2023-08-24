import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {
        var cadastroProduto = new CadastroProduto();
        List<Produto> produtos = cadastroProduto.obterTodos();

//        produtos.stream()
//                .forEach(produto -> {
//                    produto.ativar();
//                    System.out.println(produto);
//                });

//                produtos.stream()
//                        .peek(Produto::ativar)
//                        .forEach(System.out::println);


//         produtos.stream()
//                 .peek(produto -> produto.setNome(produto.getNome().toUpperCase()))
//                 .peek(System.out::println)
//                 .filter(Produto::temEstoque)
//                 .filter(Produto::isInativo)
//                 .forEach(produto -> {
//                     System.out.println("Ativando "+produto);
//                     produto.ativar();
//
//                 });


//        var produtoOptional = produtos.stream()
//                .peek(System.out::println)
//                .filter(Produto::temEstoque)
//                .filter(Produto::isInativo)
//                .findFirst();
//
//
//        System.out.println("------");
//
//        Produto produto = produtoOptional.orElseThrow(()-> new RuntimeException("Produto não encontrado"));
//
//        System.out.println(produto);

//        var produtoOptional2 = produtos.stream()
//                .filter(Produto::temEstoque)
//                .filter(Produto::isAtivo)
//                .findFirst()
//                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));
//
//        System.out.println(produtoOptional2);



//        boolean temprodutoNoEstoque =  produtos.stream()
//                .anyMatch(Produto::temEstoque);
//        System.out.println(temprodutoNoEstoque);


//        produtos.stream()
//                .filter(Produto::temEstoque)
//                .sorted(Comparator.comparingInt(Produto::getQuantidade))
//                .forEach(produto -> System.out.printf("%s = %d unidades%n",
//                        produto.getNome(), produto.getQuantidade()));



//        produtos.stream()
//                .filter(Produto::temEstoque)
//                .map(Produto::getFabricante)
//                .distinct()
//                .sorted(Comparator.comparing(Fabricante::nome))
//                .forEach(System.out::println);


//        produtos.stream()
//                .filter(Produto::temEstoque)
//                .flatMap(produto -> produto.getCategorias().stream())
//                .distinct()
//                .forEach(System.out::println);


//      int somatoria =   produtos.stream()
//                .mapToInt(Produto::getQuantidade)
//                .reduce(0, Integer::sum);
//
//        System.out.println(somatoria);


//      int soma =  produtos.stream()
//                .mapToInt(Produto::getQuantidade)
//                .sum();
//        System.out.println(soma);


//        int menorQuantidade =  produtos.stream()
//                .filter(Produto::temEstoque)
//                .mapToInt(Produto::getQuantidade)
//                .min()
//                .orElseThrow(()-> new RuntimeException("Menor quantidade nao encontrada"));
//
//        System.out.println(menorQuantidade);

//       Produto produtoMaisBarato = produtos.stream()
//                .filter(Produto::temEstoque)
//                .min(Comparator.comparing(Produto::getPreco))
//                .orElseThrow(()-> new RuntimeException("Produto mais barato não exite"));
//
//        System.out.println(produtoMaisBarato);


        List<Categoria> categorias = produtos.stream()
                .filter(Produto::temEstoque)
                .flatMap(produto -> produto.getCategorias().stream())
                .distinct()
                .collect(Collectors.toList());

        categorias.stream().forEach(System.out::println);

    }
}
