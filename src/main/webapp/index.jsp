<%@ page import="ru.reeson2003.diystore.model.service.ArtisanManager" %>
<%@ page import="ru.reeson2003.diystore.model.domain.Artisan" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="ru.reeson2003.diystore.model.service.ProductManager" %>
<%@ page import="ru.reeson2003.diystore.model.service.MessageManager" %>
<%@ page import="ru.reeson2003.diystore.model.domain.Product" %>
<%@ page import="ru.reeson2003.diystore.model.domain.Message" %>
<%@ page import="java.util.Arrays" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="index.jsp"><h3>index</h3></a>
<%
    ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");

    ArtisanManager artisanManager = context.getBean(ArtisanManager.class);
    ProductManager productManager = context.getBean(ProductManager.class);
    MessageManager messageManager = context.getBean(MessageManager.class);

    Product socks = new Product("Socks", 120L);
    Product pants = new Product("Pants", 214L);
    Product cake = new Product("Cake", 43L);
    Product bread = new Product("Bread", 14L);
    Product spoon = new Product("Spoon", 35L);
    Product fork = new Product("Fork", 37L);

    Message buySocks = new Message("Byu socks");
    buySocks.setProduct(socks);
    Message buyPants = new Message("Buy pants");
    buyPants.setProduct(pants);
    Message buyCake = new Message("Buy cake");
    buyCake.setProduct(cake);
    Message buyBread = new Message("Buy bread");
    buyBread.setProduct(bread);
    Message buySpoon = new Message("Buy spoon");
    buySpoon.setProduct(spoon);
    Message buyFork = new Message("Buy fork");
    buyFork.setProduct(fork);

    Artisan tailor = new Artisan("John Tailor", "j.tailor@mail.com", "12345");
    tailor.setProducts(Arrays.asList(socks, pants));
    tailor.setMessages(Arrays.asList(buySocks, buyPants));
    Artisan baker = new Artisan("Alice Baker", "abc@mail.net", "234234");
    baker.setProducts(Arrays.asList(cake, bread));
    baker.setMessages(Arrays.asList(buyCake, buyBread));
    Artisan smith = new Artisan("Tom Smith", "black@smith.com", "34Ghlsj*9JHgjK");
    smith.setProducts(Arrays.asList(spoon, fork));
    smith.setMessages(Arrays.asList(buySpoon, buyFork));

    artisanManager.add(tailor);
    artisanManager.add(baker);
    artisanManager.add(smith);
%>
<%=artisanManager.getByUserName("John Tailor").toString()%>
<br>
<%=artisanManager.getByUserName("Alice Baker").toString()%>
<br>
<%=artisanManager.getByUserName("Tom Smith").toString()%>
</body>
</html>
