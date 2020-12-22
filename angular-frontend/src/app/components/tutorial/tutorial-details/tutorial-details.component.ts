import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { TutorialService } from '../../../services/tutorial.service';
import { Tutorial } from '../../../classes/tutorial';

@Component({
  selector: 'app-tutorial-details',
  templateUrl: './tutorial-details.component.html',
  styleUrls: ['./tutorial-details.component.css']
})
export class TutorialDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['tutorials']);
  }
  updateLink(){
    this.router.navigate(['update/' + this.tutorial.id]);
  }

}
