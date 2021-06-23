class SelectBox {
    constructor( tittle,link,result,card,id) {
        this.getNodes( tittle,link,result,card,id);
        this.addEventListeners();
    }
    
    getNodes(tittle,link,result,card,id) {
        this.title = document.querySelector(""+""+tittle);
        this.links = Array.from(document.querySelectorAll(""+""+link));
        this.resultNodes = Array.from(document.querySelectorAll(""+""+result));
        this.cardNode = document.querySelector(""+" .card"+" "+card);
        this.id = id
    }
    
    addEventListeners() {
        this.links.map(link => link.addEventListener("click", this.changeContent.bind(this)));
    }
    
    changeContent(event) {
        event.preventDefault();
        
        const closestLink = event.target.closest("a");
        const closestLinkClone = closestLink.cloneNode(true);
        closestLinkClone.querySelector("span").remove();
        
        const iconNode = this.title.lastChild.cloneNode(true);
        
        this.title.innerHTML = closestLinkClone.textContent;
        this.title.appendChild(iconNode);
        
        this.title.click();
        var link = document.getElementById("vercatalogo"+this.id);
        link.setAttribute("href", "/catalogo/producto?modelo="+closestLinkClone.textContent);
        
        const resultIndex = this.links.indexOf(closestLink);
        this.showResult(resultIndex);
    }
    
    showResult(index) {
        this.resultNodes.map(resultNode => resultNode.classList.remove("selectbox-result-show"));
        console.log(index)
        console.log(JSON.stringify(this.resultNodes[index]))
        this.resultNodes[index].classList.add("selectbox-result-show");
        this.cardNode.classList.add("card-selected");
    }
}



// const selectBox = new SelectBox("","","","","");
const selectBox = new SelectBox(".selectbox-title0",".selectbox-link0",".selectbox-result0",".accordion-select0","0");
const selectBox1 = new SelectBox(".selectbox-title1",".selectbox-link1",".selectbox-result1",".accordion-select1","1");