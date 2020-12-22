import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TutorialService } from '../../../services/tutorial.service';
import { Tutorial } from '../../../classes/tutorial';

@Component({
  selector: 'app-tutorial-list',
  templateUrl: './tutorial-list.component.html',
  styleUrls: ['./tutorial-list.component.css']
})
export class TutorialListComponent implements OnInit {
  tutorials: Observable<Tutorial[]>;

  constructor(private tutorialService: TutorialService, private router: Router) { }

  ngOnInit(): void {
    console.log('Tutorial list');
    this.reloadData();
  }

  reloadData(){
    this.tutorials = this.tutorialService.getAll();
    console.log(this.tutorials);
  }

  deleteTutorial(id: string) {
    this.tutorialService.delete(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  tutorialDetails(id: string){
    this.router.navigate(['tutorialDetails', id]);
  }

  updateTutorial(id: string){
    this.router.navigate(['updateTutorial', id]);
  }
}
