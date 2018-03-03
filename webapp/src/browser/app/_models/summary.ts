export class Summary {
  sumTaxRate: number;
  sumNetto: number;
  sumVat: number;
  sumBrutto: number;

  constructor(sumTaxRate: number, sumNetto:number, sumVat:number, sumBrutto:number) {
    this.sumTaxRate = sumTaxRate;
    this.sumNetto = sumNetto;
    this.sumVat = sumVat;
    this.sumBrutto = sumBrutto;
  }
}
