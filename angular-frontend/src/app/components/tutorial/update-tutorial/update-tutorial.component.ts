import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TutorialService } from '../../../services/tutorial.service';
import { Tutorial } from '../../../classes/tutorial';

@Component({
  selector: 'app-update-tutorial',
  templateUrl: './update-tutorial.component.html',
  styleUrls: ['./update-tutorial.component.css']
})
export class UpdateTutorialComponent implements OnInit {

  id: string;
  tutorial: Tutorial;

  constructor(private route: ActivatedRoute, private router: Router,
              private tutorialService: TutorialService) { }

  ngOnInit() {
    this.tutorial = new Tutorial();

    this.id = this.route.snapshot.params['id'];

    this.tutorialService.get(this.id)
      .subscribe(data => {
        console.log(data);
        this.tutorial = data;
      }, error => console.log(error));
  }

  updateTutorial(){
    // this.tutorial = new Tutorial();
    // this.id = this.route.snapshot.params['id'];
    this.tutorialService.update(this.id, this.tutorial).subscribe(
      data => {
        console.log(data);
        this.tutorial = new Tutorial();
        this.list();
      }, error => console.log(error)
    );
  }

  onSubmit(){
    this.updateTutorial();
  }

  list(){
    this.router.navigate(['tutorials']);
  }

}
